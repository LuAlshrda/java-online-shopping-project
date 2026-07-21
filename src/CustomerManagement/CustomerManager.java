package CustomerManagement;

/**
 CustomerManager is responsible for the business logic of the module. 
 It stores the customers in an ArrayList, calls CustomerFileHandler to save/load them, 
 and provides methods for adding, updating, deleting, and searching customers.
 */
import java.util.ArrayList;

public class CustomerManager{

    private ArrayList<Customer> customers;
    private CustomerFileHandler fileHandler;

    public CustomerManager(){
        fileHandler = new CustomerFileHandler();
        customers = fileHandler.loadCustomers();
    }
//return all customers
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    //ad a new customer
    public boolean addCustomer(Customer customer){

    //check for duplicate ID
        for (Customer c : customers){
            if (c.getCustomerId().equalsIgnoreCase(customer.getCustomerId())){
                return false;
            }
        }

        customers.add(customer);
        fileHandler.saveCustomers(customers);
        return true;
    }

    //delete customer by ID
    public boolean deleteCustomer(String customerId){

        for (Customer c : customers){
            if (c.getCustomerId().equalsIgnoreCase(customerId)){
                customers.remove(c);
                fileHandler.saveCustomers(customers);
                return true;
            }
        }

        return false;
    }
 //return customer by id   
    public Customer getCustomer(String customerId){
        return findCustomerById(customerId);
    }
    
 //find customer by ID
    public Customer findCustomerById(String customerId){

        for (Customer c : customers){
            if (c.getCustomerId().equalsIgnoreCase(customerId)){
                return c;
            }
        }

        return null;
    }

  //search by any field
    public ArrayList<Customer> searchCustomers(String keyword){

        ArrayList<Customer> results = new ArrayList<>();

        keyword = keyword.toLowerCase();

        for (Customer c : customers) {

            if (c.getCustomerId().toLowerCase().contains(keyword)||
                c.getCustomerName().toLowerCase().contains(keyword)||
                c.getPhone().toLowerCase().contains(keyword)||
                c.getEmail().toLowerCase().contains(keyword)||
                c.getCity().toLowerCase().contains(keyword)||
                c.getStatus().toString().toLowerCase().contains(keyword)){

                results.add(c);
            }
        }

        return results;
    }

    //update an existing customer
    public boolean updateCustomer(Customer updatedCustomer){

        for (int i = 0; i < customers.size(); i++){

            if (customers.get(i).getCustomerId()
                    .equalsIgnoreCase(updatedCustomer.getCustomerId())){

                customers.set(i, updatedCustomer);
                fileHandler.saveCustomers(customers);
                return true;
            }
        }

        return false;
    }

    //count active customers
    public int getActiveCustomers(){

        int count = 0;

        for (Customer c : customers){
            if (c.getStatus() == CustomerStatus.ACTIVE){
                count++;
            }
        }

        return count;
    }

    //count inactive customers
    public int getInactiveCustomers(){

        int count = 0;

        for (Customer c : customers){
            if (c.getStatus() == CustomerStatus.INACTIVE){
                count++;
            }
        }

        return count;
    }

    // Count blocked customers
    public int getBlockedCustomers(){

        int count = 0;

        for (Customer c : customers){
            if (c.getStatus() == CustomerStatus.BLOCKED){
                count++;
            }
        }

        return count;
    }
    
    public Customer findCustomerByUsername(String username){

    for(Customer customer : customers){

        if(customer.getUsername().equalsIgnoreCase(username)){

            return customer;

        }

    }

    return null;

    }
}

