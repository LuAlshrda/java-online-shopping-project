/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispatchManagement;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author shahad 
 */

public class DeliveryPersonFileHandler {

    private static final String FILE_NAME = "deliveryPersons.dat";

    public static void saveDeliveryPersons(
            ArrayList<DeliveryPerson> deliveryPersons) {

        try {
            FileOutputStream fileOut =new FileOutputStream(FILE_NAME);

            ObjectOutputStream out =new ObjectOutputStream(fileOut);

            out.writeObject(deliveryPersons);

            out.close();
            fileOut.close();

            System.out.println("Delivery persons written to file successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<DeliveryPerson> loadDeliveryPersons() {

        try {
            FileInputStream fileIn =new FileInputStream(FILE_NAME);

            ObjectInputStream in =new ObjectInputStream(fileIn);

            ArrayList<DeliveryPerson> deliveryPersons =(ArrayList<DeliveryPerson>) in.readObject();

            in.close();
            fileIn.close();

            return deliveryPersons;

        } catch (Exception e) {
            System.out.println("No saved delivery person file found.");

            return new ArrayList<>();
        }
    }
}

