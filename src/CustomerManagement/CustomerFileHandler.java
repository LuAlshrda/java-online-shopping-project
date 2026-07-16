
package CustomerManagement;





import java.io.*;
import java.util.ArrayList;

public class CustomerFileHandler {

    private static final String file_name = "customers.dat";

    // save customers to file
    public void saveCustomers(ArrayList<Customer> customers){

        try{
            FileOutputStream fileOut = new FileOutputStream(file_name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(customers);

            out.close();
            fileOut.close();

            System.out.println("Customers saved successfully.");

        } catch (IOException e){
            
            e.printStackTrace();
        }
    }

    // Load customers from file
    public ArrayList<Customer> loadCustomers(){

        ArrayList<Customer> customers = new ArrayList<>();

        try{

            FileInputStream fileIn = new FileInputStream(file_name);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            customers = (ArrayList<Customer>) in.readObject();

            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("No customer file found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return customers;
    }
}
