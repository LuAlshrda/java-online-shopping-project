/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderManagement;

/**
 *
 * @author Sham
 */
public enum OrderStatus {
    PLACED,             // تم الطلب
    CONFIRMED,          // مؤكد
    PACKED,             // مجهز
    READY_FOR_DISPATCH, // جاهز للتوصيل
    CANCELLED           // ملغي

}
