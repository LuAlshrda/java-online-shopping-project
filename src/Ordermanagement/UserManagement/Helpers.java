/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserManagement;

/**
 *
 * @author Sham
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HexFormat;

public class Helpers {

    private static final String USERS_FILE = "users.dat";

    private static ArrayList<User> users =
            new ArrayList<>();

    /*
     * المستخدم الذي نجح في تسجيل الدخول.
     */
    private static User currentUser;

    private Helpers() {
        // Prevent creating Helpers objects.
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout() {
        currentUser = null;
    }

    /*
     * تشفير كلمة المرور باستخدام SHA-256.
     */
    public static String hashDigest(String text) {

        if (text == null) {
            return "";
        }

        try {

            MessageDigest md =
                    MessageDigest.getInstance("SHA-256");

            byte[] digest =
                    md.digest(text.getBytes());

            return HexFormat.of()
                    .formatHex(digest);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Password could not be encrypted.",
                    e
            );
        }
    }

    /*
     * التحقق من وجود username سابقًا.
     */
    public static boolean exists(String username) {

        if (username == null) {
            return false;
        }

        for (User user : users) {

            if (user.getName()
                    .trim()
                    .equalsIgnoreCase(username.trim())) {

                return true;
            }
        }

        return false;
    }

    /*
     * إنشاء مستخدم جديد.
     */
    public static String addUser(
            String username,
            String password,
            String email,
            String role) {

        if (username == null
                || username.trim().isEmpty()) {

            return "Failed: Username is required.";
        }

        if (password == null
                || password.isEmpty()) {

            return "Failed: Password is required.";
        }

        if (email == null
                || email.trim().isEmpty()) {

            return "Failed: Email is required.";
        }

        if (role == null
                || role.trim().isEmpty()) {

            return "Failed: Role is required.";
        }

        if (exists(username)) {

            return "Failed: Username already exists.";
        }

        String passwordHash =
                hashDigest(password);

        User user = new User(
                username.trim(),
                passwordHash,
                email.trim(),
                role.trim()
        );

        users.add(user);
        writeFile();

        return "Success: Account created successfully.";
    }

    /*
     * تسجيل الدخول.
     */
    public static boolean authenticate(
            String username,
            String passwordHash) {

        if (username == null
                || passwordHash == null) {

            currentUser = null;
            return false;
        }

        for (User user : users) {

            boolean sameUsername =
                    user.getName()
                            .trim()
                            .equalsIgnoreCase(
                                    username.trim()
                            );

            boolean samePassword =
                    user.getPassword()
                            .equals(passwordHash);

            if (sameUsername && samePassword) {

                currentUser = user;
                return true;
            }
        }

        currentUser = null;
        return false;
    }

    /*
     * حفظ المستخدمين في users.dat.
     */
    public static void writeFile() {

        try (ObjectOutputStream output =
                new ObjectOutputStream(
                        new FileOutputStream(
                                USERS_FILE
                        ))) {

            output.writeObject(users);

        } catch (Exception e) {

            System.err.println(
                    "Error saving users: "
                    + e.getMessage()
            );
        }
    }

    /*
     * قراءة المستخدمين عند تشغيل البرنامج.
     */
    @SuppressWarnings("unchecked")
    public static void readFile() {

        File file = new File(USERS_FILE);

        if (!file.exists()) {

            users = new ArrayList<>();

            /*
             * ننشئ Admin افتراضي حتى تستطيعوا
             * تجربة البرنامج أول مرة.
             */
            createDefaultAdmin();
            return;
        }

        try (ObjectInputStream input =
                new ObjectInputStream(
                        new FileInputStream(file)
                )) {

            users =
                    (ArrayList<User>)
                            input.readObject();

        } catch (Exception e) {

            System.err.println(
                    "Error loading users: "
                    + e.getMessage()
            );

            users = new ArrayList<>();
            createDefaultAdmin();
        }
    }

    /*
     * Admin تجريبي:
     * Username: admin
     * Password: admin123
     */
    private static void createDefaultAdmin() {

        User admin = new User(
                "admin",
                hashDigest("admin123"),
                "admin@shop.com",
                "Admin"
        );

        users.add(admin);
        writeFile();
    }
}
