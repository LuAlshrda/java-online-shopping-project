
package CustomerManagement;

/*

 Module 2
 Customer Management
 Lulwa Alshereedah
 ID: 2231123460
 
 */
import java.io.Serializable;

public class Customer implements Serializable {
    private String username;
    private String customerId;
    private String customerName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String registrationDate;
    private CustomerStatus status;
    
    //default constructor
    public Customer(){}
    
    //parameterized constructor
    public Customer(String username, String customerId, String customerName, String phone, String email, String address, String city, String registrationDate, CustomerStatus status) {
        this.username = username;
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.registrationDate = registrationDate;
        this.status = status;
    }
    
    //getters and setters
    public String getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getAddress()
    {
        return address;
    }
    @SuppressWarnings("SillyAssignment")
    public void setAddress(String Address)
    {
        this.address = address;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getRegistrationDate()
    {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate)
    {
        this.registrationDate = registrationDate;
    }
    public CustomerStatus getStatus()
    {
        return status;
    }
    public void setStatus(CustomerStatus status)
    {
        this.status = status;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return customerId + " - " + customerName;
    }
}
