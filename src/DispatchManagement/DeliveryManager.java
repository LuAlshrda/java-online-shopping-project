/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispatchManagement;
import java.util.ArrayList;

/**
 *
 * @author shahad
 */
  




public class DeliveryManager {

    private ArrayList<Delivery> deliveryList;

  
    public DeliveryManager() {
        deliveryList = new ArrayList<>();
    }

   
    public void setDeliveryList(ArrayList<Delivery> deliveryList) {

        if (deliveryList == null) {
            this.deliveryList = new ArrayList<>();
        } else {
            this.deliveryList = deliveryList;
        }
    }

    
    public boolean addDelivery(Delivery delivery) {

        if (!validateDelivery(delivery)) {
            return false;
        }

        
        if (searchDelivery(delivery.getDeliveryId()) != null) {
            return false;
        }

        
        if (searchByOrderId(delivery.getOrderId()) != null) {
            return false;
        }

        deliveryList.add(delivery);
        return true;
    }

    
    public Delivery searchDelivery(String deliveryId) {

        if (deliveryId == null
                || deliveryId.trim().isEmpty()) {
            return null;
        }

        for (Delivery delivery : deliveryList) {

            if (delivery.getDeliveryId()
                    .equalsIgnoreCase(deliveryId.trim())) {

                return delivery;
            }
        }

        return null;
    }

    
    public Delivery searchByOrderId(String orderId) {

        if (orderId == null
                || orderId.trim().isEmpty()) {
            return null;
        }

        for (Delivery delivery : deliveryList) {

            if (delivery.getOrderId()
                    .equalsIgnoreCase(orderId.trim())) {

                return delivery;
            }
        }

        return null;
    }

    
    public ArrayList<Delivery> searchByDeliveryPerson(
            String deliveryPersonName) {

        ArrayList<Delivery> results = new ArrayList<>();

        if (deliveryPersonName == null
                || deliveryPersonName.trim().isEmpty()) {
            return results;
        }

        for (Delivery delivery : deliveryList) {

            if (delivery.getDeliveryPersonName()
                    .equalsIgnoreCase(
                            deliveryPersonName.trim())) {

                results.add(delivery);
            }
        }

        return results;
    }


    public ArrayList<Delivery> searchByStatus(
            DeliveryStatus deliveryStatus) {

        ArrayList<Delivery> results = new ArrayList<>();

        if (deliveryStatus == null) {
            return results;
        }

        for (Delivery delivery : deliveryList) {

            if (delivery.getDeliveryStatus()
                    == deliveryStatus) {

                results.add(delivery);
            }
        }

        return results;
    }

 
    public boolean updateDelivery(
            String originalDeliveryId,
            Delivery updatedDelivery) {

        if (originalDeliveryId == null
                || originalDeliveryId.trim().isEmpty()) {
            return false;
        }

        if (!validateDelivery(updatedDelivery)) {
            return false;
        }

        int deliveryIndex = -1;

     
        for (int i = 0; i < deliveryList.size(); i++) {

            Delivery currentDelivery =
                    deliveryList.get(i);

            if (currentDelivery.getDeliveryId()
                    .equalsIgnoreCase(
                            originalDeliveryId.trim())) {

                deliveryIndex = i;
                break;
            }
        }

        if (deliveryIndex == -1) {
            return false;
        }

      
        for (int i = 0; i < deliveryList.size(); i++) {

            if (i != deliveryIndex) {

                Delivery otherDelivery =
                        deliveryList.get(i);

                if (otherDelivery.getDeliveryId()
                        .equalsIgnoreCase(
                                updatedDelivery
                                        .getDeliveryId()
                                        .trim())) {

                    return false;
                }

                if (otherDelivery.getOrderId()
                        .equalsIgnoreCase(
                                updatedDelivery
                                        .getOrderId()
                                        .trim())) {

                    return false;
                }
            }
        }

        deliveryList.set(deliveryIndex, updatedDelivery);
        return true;
    }

   
    public boolean deleteDelivery(String deliveryId) {

        Delivery delivery =
                searchDelivery(deliveryId);

        if (delivery == null) {
            return false;
        }

        deliveryList.remove(delivery);
        return true;
    }

    
    public boolean updateDeliveryStatus(
            String deliveryId,
            DeliveryStatus newStatus) {

        Delivery delivery =
                searchDelivery(deliveryId);

        if (delivery == null
                || newStatus == null) {

            return false;
        }

        delivery.setDeliveryStatus(newStatus);
        return true;
    }


    public ArrayList<Delivery> getAllDeliveries() {
        return deliveryList;
    }

   
    public int getTotalDeliveries() {
        return deliveryList.size();
    }

    
    public int countDeliveriesByStatus(
            DeliveryStatus deliveryStatus) {

        int count = 0;

        if (deliveryStatus == null) {
            return count;
        }

        for (Delivery delivery : deliveryList) {

            if (delivery.getDeliveryStatus()
                    == deliveryStatus) {

                count++;
            }
        }

        return count;
    }

   
    private boolean validateDelivery(Delivery delivery) {

        if (delivery == null) {
            return false;
        }

        if (delivery.getDeliveryId() == null
                || delivery.getDeliveryId()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getOrderId() == null
                || delivery.getOrderId()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getDeliveryPersonName() == null
                || delivery.getDeliveryPersonName()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getDeliveryPersonPhone() == null
                || delivery.getDeliveryPersonPhone()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getDispatchDate() == null
                || delivery.getDispatchDate()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getExpectedDeliveryDate() == null
                || delivery.getExpectedDeliveryDate()
                        .trim().isEmpty()) {
            return false;
        }

        if (delivery.getDeliveryStatus() == null) {
            return false;
        }

       
        if (delivery.getDeliveryStatus()
                == DeliveryStatus.DELIVERED) {

            if (delivery.getActualDeliveryDate() == null
                    || delivery.getActualDeliveryDate()
                            .trim().isEmpty()) {

                return false;
            }
        }

        
        if (delivery.getDeliveryStatus()
                == DeliveryStatus.FAILED
                || delivery.getDeliveryStatus()
                == DeliveryStatus.RETURNED) {

            if (delivery.getRemarks() == null
                    || delivery.getRemarks()
                            .trim().isEmpty()) {

                return false;
            }
        }

        return true;
    }
}