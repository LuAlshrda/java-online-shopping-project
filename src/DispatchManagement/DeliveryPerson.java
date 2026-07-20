/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DispatchManagement;
import java.io.Serializable;

/**
 *
 * @author shahad
 */
public class DeliveryPerson implements Serializable {
    private String deliveryPersonId;
    private String personName;
    private String phone;
    private String vehicle;
    
    public DeliveryPerson(String deliveryPersonId,String personName, String phone, String vehicle ){
        this.deliveryPersonId=deliveryPersonId;
        this.personName=personName;
        this.phone=phone;
        this.vehicle=vehicle;
    }
    public String getDeliveryPersonId(){
        return deliveryPersonId;
    }
    public void setDeliveryPersonId(String deliveryPersonId){
        this.deliveryPersonId=deliveryPersonId;
    }
     public String getPersonName(){
        return personName;
    }
     public void setPersonName(String personName){
       this.personName=personName;
    }
     public String getPhone(){
        return phone;
    }
     public void setPhone(String phone){
     this.phone=phone;
    }
    public String getVehicle(){
        return vehicle;
    }
    public void setVehicle(String vehicle){
     this.vehicle=vehicle;
    }
    @Override 
    public String toString(){
        return deliveryPersonId+" - "+personName;
    }
}
