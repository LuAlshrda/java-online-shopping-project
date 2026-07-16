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
public class Delivery implements Serializable {
    private String deliveryId;
    private String orderId;
    private String deliveryPersonName;
    private String deliveryPersonPhone;
    private String vehicleNumber;
    private String dispatchDate;
    private String expectedDeliveryDate;
    private String actualDeliveryDate;
    private DeliveryStatus deliveryStatus;
    private String remarks;

    public Delivery(String deliveryId, String orderId,String deliveryPersonName, String deliveryPersonPhone, String vehicleNumber,String dispatchDate,String expectedDeliveryDate, String actualDeliveryDate, DeliveryStatus deliveryStatus, String remarks) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryPersonPhone = deliveryPersonPhone;
        this.vehicleNumber = vehicleNumber;
        this.dispatchDate = dispatchDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.remarks = remarks;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public void setDeliveryPersonPhone(String deliveryPersonPhone) {
        this.deliveryPersonPhone = deliveryPersonPhone;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void setActualDeliveryDate(String actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public String getDeliveryPersonPhone() {
        return deliveryPersonPhone;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public String getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getRemarks() {
        return remarks;
    }
}