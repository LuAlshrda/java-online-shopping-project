/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

/**
 *
 * @author Sham
 */


import UserManagement.Helpers;
import UserManagement.frmSighIn;

public class OnlineShoppingManagement {

    public static void main(String[] args) {

        Helpers.readFile();

        java.awt.EventQueue.invokeLater(() -> {

            frmSighIn login =
                    new frmSighIn();

            login.setVisible(true);
        });
    }
}
