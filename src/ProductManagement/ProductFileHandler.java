package ProductManagement;

/*
 *  This class handles the binary file input and output operations for products It also manages the layer of the application by saving and loading the product list 
 * to  physical file on the disk using Java Serialization
 * It provides constructors to define a custom file name or default to a standard file 
*/
import java.io.*;
import java.util.ArrayList;

public class ProductFileHandler {

    private String fileName;

    public ProductFileHandler() {
        fileName = "products.txt";
    }

    public ProductFileHandler(String fileName) {
        this.fileName = fileName;
    }

    
    public void saveProducts(ArrayList<Product> productList) {

        try {
            FileOutputStream fileOut=new FileOutputStream(fileName);

            ObjectOutputStream out=new ObjectOutputStream(fileOut);

            out.writeObject(productList);

            out.close();
            fileOut.close();

            System.out.println("Products saved successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public ArrayList<Product> loadProducts() {

        ArrayList<Product> productList =new ArrayList<>();

        try {
            FileInputStream fileIn =new FileInputStream(fileName);

            ObjectInputStream in=new ObjectInputStream(fileIn);

            productList=(ArrayList<Product>) in.readObject();

            in.close();
            fileIn.close();

            System.out.println("Products loaded successfully.");

        } catch (Exception e) {
            System.out.println("No saved product file found.");
        }
        return productList;
    }
}
