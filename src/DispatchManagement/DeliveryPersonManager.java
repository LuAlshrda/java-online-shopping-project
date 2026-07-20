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

public class DeliveryPersonManager {

    private ArrayList<DeliveryPerson> deliveryPersons;

    public DeliveryPersonManager() {
        deliveryPersons =DeliveryPersonFileHandler.loadDeliveryPersons();
    }

    public ArrayList<DeliveryPerson> getDeliveryPersons() {
        return deliveryPersons;
    }

    public boolean addDeliveryPerson(DeliveryPerson person) {

        if (person==null) {
            return false;
        }

        if (findById(person.getDeliveryPersonId()) != null) {
            return false;
        }

        deliveryPersons.add(person);
        saveDeliveryPersons();

        return true;
    }

    public DeliveryPerson findById(String id) {

        for (DeliveryPerson person : deliveryPersons) {

            if (person.getDeliveryPersonId().equalsIgnoreCase(id)) {

                return person;
            }
        }

        return null;
    }

    public DeliveryPerson findByName(String name) {

        for (DeliveryPerson person : deliveryPersons) {

            if (person.getPersonName().equalsIgnoreCase(name)) {

                return person;
            }
        }

        return null;
    }

    public boolean deleteDeliveryPerson(String id) {

        DeliveryPerson person = findById(id);

        if (person==null) {
            return false;
        }

        deliveryPersons.remove(person);
        saveDeliveryPersons();

        return true;
    }

    public boolean updateDeliveryPerson(
            String originalId,
            DeliveryPerson updatedPerson) {

        for (int i = 0; i < deliveryPersons.size(); i++) {

            DeliveryPerson current =deliveryPersons.get(i);

            if (current.getDeliveryPersonId().equalsIgnoreCase(originalId)) {

                deliveryPersons.set(i, updatedPerson);
                saveDeliveryPersons();

                return true;
            }
        }

        return false;
    }

    public void saveDeliveryPersons() {
        DeliveryPersonFileHandler.saveDeliveryPersons(deliveryPersons);
    }
}

