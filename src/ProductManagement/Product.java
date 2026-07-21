package ProductManagement;

import java.io.Serializable;

public class Product implements Serializable {

    private String productId;
    private String productName;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private String description;
    private ProductStatus productStatus;
    
    public Product(){}
    
    public Product(String productId, String productName, String category, String brand, 
                   double price, int quantity, String description, ProductStatus productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.productStatus = productStatus;
    }

    // Integrated Validation Methods (Accessible via Product class)
    
    public static boolean isNotEmpty(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isValidPrice(String priceStr) {
        try {
            double price = Double.parseDouble(priceStr);
            if (price < 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidQuantity(String qtyStr) {
        try {
            int qty = Integer.parseInt(qtyStr);
            //  This currently rejects any quantity less than 0
            if (qty < 0) { 
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        // update the status based on inventory stock quantity
        if (this.quantity <= 0 && this.productStatus != ProductStatus.DISCONTINUED) {
            this.productStatus = ProductStatus.OUT_OF_STOCK;
        } else if (this.quantity > 0 && this.productStatus == ProductStatus.OUT_OF_STOCK) {
            this.productStatus = ProductStatus.AVAILABLE;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    // Displays product details 
    public void display() {
        System.out.println("ID: " + productId + " | Name: " + productName + " | Category: " + category + " | Price: $" + price + " | Qusntity: " + quantity + " | Status: " + productStatus);
    }
}
