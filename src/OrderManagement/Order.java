/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

/**
 *
 * @author Sham
 */
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Sham
 */
    
public class Order implements Serializable {
    private static final long serialVersionUID = 1L; // لضمان التوافق التام أثناء الحفظ والقراءة

    
    private String id;
    private String customerId;
    private String customerName;
    private String productId;
    private String productName;
    private int quantity;
    private double total;
    private Date orderDate;
    private String deliveryAddress;
    private OrderStatus status;

    public Order(String id, String customerId, String customerName, String productId,
                 String productName, int quantity, double total, Date orderDate,
                 String deliveryAddress, OrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
    }

    // ------ Getters و Setters ------
    public String getOrderId() { return id; }
    public void setOrderId(String id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    @Override
    public String toString() {
        return id + " - " + customerName + " - " + productName;
    }
}

