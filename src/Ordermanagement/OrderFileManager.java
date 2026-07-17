/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

/**
 *
 * @author Sham
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderFileManager {

    private static final String ORDERS_FILE = "orders.dat";

    public static void saveOrders(ArrayList<Order> orders) {

        try (ObjectOutputStream output =
                new ObjectOutputStream(
                        new FileOutputStream(ORDERS_FILE))) {

            output.writeObject(orders);

        } catch (IOException e) {
            System.err.println(
                    "Error saving orders: " + e.getMessage()
            );
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Order> loadOrders() {

        File file = new File(ORDERS_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                new ObjectInputStream(
                        new FileInputStream(file))) {

            return (ArrayList<Order>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.err.println(
                    "Error loading orders: " + e.getMessage()
            );

            return new ArrayList<>();
        }
    }
}
