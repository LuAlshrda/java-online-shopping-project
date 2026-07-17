package ProductManagement;

/**
* product management stores the products in an ArrayList calls ProductFileHandler to save them, 
* and provides methods for adding, updating, deleting, and searching products.
 */
import java.util.ArrayList;

public class ProductManager{

    private final ArrayList<Product> products;
    private final ProductFileHandler fileHandler;

    public ProductManager(){
        fileHandler = new ProductFileHandler();
        products = fileHandler.loadProducts();
    }
//return all products
    public ArrayList<Product> getProducts(){
        return products;
    }
    
    //add a new product
    public boolean addProduct(Product product){
        
        for (Product p : products){
            if (p.getProductId().equalsIgnoreCase(product.getProductId())){
                return false;
            }
        }

        products.add(product);
        fileHandler.saveProducts(products);
        return true;
    }

    
    public boolean deleteProduct(String productId){

        for (Product p : products){
            if (p.getProductId().equalsIgnoreCase(productId)){
                products.remove(p);
                fileHandler.saveProducts(products);
                return true;
            }
        }

        return false;
    }
 //return product by id   
    public Product getProduct(String productId){
        return findProductById(productId);
    }
    
 //find product by ID
    public Product findProductById(String productId){

        for (Product p : products){
            if (p.getProductId().equalsIgnoreCase(productId)){
                return p;
            }
        }

        return null;
    }

  
    public ArrayList<Product> searchProducts(String keyword){

        ArrayList<Product> results = new ArrayList<>();

        keyword = keyword.toLowerCase();

        for (Product p : products) {

            if (p.getProductId().toLowerCase().contains(keyword)|| p.getProductName().toLowerCase().contains(keyword)|| p.getCategory().toLowerCase().contains(keyword)||
                p.getBrand().toLowerCase().contains(keyword)||
                p.getDescription().toLowerCase().contains(keyword)||
                p.getProductStatus().toString().toLowerCase().contains(keyword)){

                results.add(p);
            }
        }

        return results;
    }

    public boolean updateProduct(Product updatedProduct){

        for (int i = 0; i < products.size(); i++){

            if (products.get(i).getProductId()
                    .equalsIgnoreCase(updatedProduct.getProductId())){

                products.set(i, updatedProduct);
                fileHandler.saveProducts(products);
                return true;
            }
        }

        return false;
    }

    
    public boolean increaseStock(String productId, int amount){

        Product p = findProductById(productId);

        if (p == null || amount <= 0){
            return false;
        }

        p.setQuantity(p.getQuantity() + amount);

        if (p.getProductStatus() == ProductStatus.OUT_OF_STOCK){
            p.setProductStatus(ProductStatus.AVAILABLE);
        }

        fileHandler.saveProducts(products);
        return true;
    }

   
    public boolean reduceStock(String productId, int amount){

        Product p = findProductById(productId);

        if (p == null || amount <= 0 || p.getQuantity() < amount){
            return false;
        }

        p.setQuantity(p.getQuantity() - amount);

        if (p.getQuantity() == 0){
            p.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }

        fileHandler.saveProducts(products);
        return true;
    }

   
    public int getAvailableProducts(){

        int count = 0;

        for (Product p : products){
            if (p.getProductStatus() == ProductStatus.AVAILABLE){
                count++;
            }
        }

        return count;
    }

    //count out of stock products
    public int getOutOfStockProducts(){

        int count = 0;

        for (Product p : products){
            if (p.getProductStatus() == ProductStatus.OUT_OF_STOCK){
                count++;
            }
        }

        return count;
    }

    public int getDiscontinuedProducts(){

        int count = 0;

        for (Product p : products){
            if (p.getProductStatus() == ProductStatus.DISCONTINUED){
                count++;
            }
        }

        return count;
    }
}
