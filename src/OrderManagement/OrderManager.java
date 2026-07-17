/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

import CustomerManagement.Customer;
import CustomerManagement.CustomerStatus;

import InventoryManagement.Product;
import InventoryManagement.ProductManager;
import InventoryManagement.ProductStatus;

import java.util.ArrayList;
import java.util.Date;

public class OrderManager {

    private ArrayList<Order> orders;
    private ProductManager productManager;

    public OrderManager() {
        orders = OrderFileManager.loadOrders();
        productManager = new ProductManager();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public String createOrder(
            String orderId,
            Customer customer,
            Product product,
            int quantity,
            String address) {

        if (orderId == null || orderId.trim().isEmpty()) {
            return "Failed: Order ID is required.";
        }

        if (customer == null) {
            return "Failed: Please select a customer.";
        }

        if (product == null) {
            return "Failed: Please select a product.";
        }

        if (quantity <= 0) {
            return "Failed: Quantity must be greater than zero.";
        }

        if (address == null || address.trim().isEmpty()) {
            return "Failed: Delivery address is required.";
        }

        // Check duplicate order ID
        for (Order order : orders) {
            if (order.getOrderId()
                    .equalsIgnoreCase(orderId.trim())) {

                return "Failed: Order ID already exists.";
            }
        }

        // Blocked customer cannot place an order
        if (customer.getStatus() == CustomerStatus.BLOCKED) {
            return "Failed: Customer is BLOCKED and cannot place orders.";
        }

        // Product must be available
        if (product.getProductStatus() != ProductStatus.AVAILABLE) {
            return "Failed: Product is not available. Status: "
                    + product.getProductStatus();
        }

        // Check available stock
        if (quantity > product.getQuantity()) {
            return "Failed: Only "
                    + product.getQuantity()
                    + " item(s) are available in stock.";
        }

        double totalAmount =
                product.getPrice() * quantity;

        // Reduce product stock using ProductManager
        boolean stockUpdated =
                productManager.reduceStock(
                        product.getProductId(),
                        quantity
                );

        if (!stockUpdated) {
            return "Failed: Product stock could not be updated.";
        }

        Order newOrder = new Order(
                orderId.trim(),
                customer.getCustomerId(),
                customer.getCustomerName(),
                product.getProductId(),
                product.getProductName(),
                quantity,
                totalAmount,
                new Date(),
                address.trim(),
                OrderStatus.PLACED
        );

        orders.add(newOrder);
        OrderFileManager.saveOrders(orders);

        return "Success: Order created successfully. Total amount: $"
                + String.format("%.2f", totalAmount);
    }

    public boolean updateOrderStatus(
            String orderId,
            OrderStatus newStatus) {

        if (orderId == null || newStatus == null) {
            return false;
        }

        for (Order order : orders) {

            if (order.getOrderId()
                    .equalsIgnoreCase(orderId)) {

                order.setStatus(newStatus);
                OrderFileManager.saveOrders(orders);
                return true;
            }
        }

        return false;
    }

    public String cancelOrder(String orderId) {

        if (orderId == null || orderId.trim().isEmpty()) {
            return "Failed: Order ID is required.";
        }

        for (Order order : orders) {

            if (order.getOrderId()
                    .equalsIgnoreCase(orderId.trim())) {

                if (order.getStatus() == OrderStatus.CANCELLED) {
                    return "Failed: Order is already cancelled.";
                }

                // Return quantity to product stock
                boolean stockRestored =
                        productManager.increaseStock(
                                order.getProductId(),
                                order.getQuantity()
                        );

                if (!stockRestored) {
                    return "Failed: Product stock could not be restored.";
                }

                order.setStatus(OrderStatus.CANCELLED);
                OrderFileManager.saveOrders(orders);

                return "Success: Order cancelled successfully.";
            }
        }

        return "Failed: Order was not found.";
    }

    public Order findOrderById(String orderId) {

        if (orderId == null) {
            return null;
        }

        for (Order order : orders) {

            if (order.getOrderId()
                    .equalsIgnoreCase(orderId.trim())) {

                return order;
            }
        }

        return null;
    }

    public ArrayList<Order> searchOrders(
            String query,
            String type) {

        ArrayList<Order> results =
                new ArrayList<>();

        if (query == null) {
            query = "";
        }

        if (type == null) {
            return results;
        }

        String normalizedQuery =
                query.trim().toLowerCase();

        for (Order order : orders) {

            boolean matches = false;

            switch (type) {

                case "Order ID":
                    matches = order.getOrderId()
                            .toLowerCase()
                            .contains(normalizedQuery);
                    break;

                case "Customer ID":
                    matches = order.getCustomerId()
                            .toLowerCase()
                            .contains(normalizedQuery);
                    break;

                case "Product ID":
                    matches = order.getProductId()
                            .toLowerCase()
                            .contains(normalizedQuery);
                    break;

                case "Status":
                    matches = order.getStatus()
                            .name()
                            .toLowerCase()
                            .contains(normalizedQuery);
                    break;

                default:
                    matches = false;
            }

            if (matches) {
                results.add(order);
            }
        }

        return results;
    }
}