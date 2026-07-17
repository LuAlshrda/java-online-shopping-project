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



public class DeliveryFileHandler {

    private String fileName;

    public DeliveryFileHandler() {
        fileName = "deliveries.txt";
    }

    public DeliveryFileHandler(String fileName) {
        this.fileName = fileName;
    }

    
    public void saveDeliveries(ArrayList<Delivery> deliveryList) {

        try {
            FileOutputStream fileOut=new FileOutputStream(fileName);

            ObjectOutputStream out=new ObjectOutputStream(fileOut);

            out.writeObject(deliveryList);

            out.close();
            fileOut.close();

            System.out.println("Deliveries saved successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public ArrayList<Delivery> loadDeliveries() {

        ArrayList<Delivery> deliveryList =new ArrayList<>();

        try {
            FileInputStream fileIn =new FileInputStream(fileName);

            ObjectInputStream in=new ObjectInputStream(fileIn);

            deliveryList=(ArrayList<Delivery>) in.readObject();

            in.close();
            fileIn.close();

            System.out.println("Deliveries loaded successfully.");

        } catch (Exception e) {
            System.out.println("No saved delivery file found.");
        }
        return deliveryList;
    }
}    
    

