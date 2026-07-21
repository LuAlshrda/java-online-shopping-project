/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;



import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Setter for Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for Role
    public String getRole() {
        return role;
    }

    // Setter for Role
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + role;
    }
}
