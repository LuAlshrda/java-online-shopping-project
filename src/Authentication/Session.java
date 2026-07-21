/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;

/**
 for get user
 */
public class Session {

    // Stores the user who is currently logged in
    private static User currentUser;

    // Set the logged-in user
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    // Get the logged-in user
    public static User getCurrentUser() {
        return currentUser;
    }

    // Clear the session (used when logging out)
    public static void logout() {
        currentUser = null;
    }

    // Check if someone is logged in
    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    // Check if the logged-in user is an Admin
    public static boolean isAdmin() {
        return currentUser != null &&
               currentUser.getRole().equalsIgnoreCase("Admin");
    }

    // Check if the logged-in user is a User
    public static boolean isUser() {
        return currentUser != null &&
               currentUser.getRole().equalsIgnoreCase("User");
    }
}
