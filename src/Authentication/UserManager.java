/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;

/**
save users
load users
check login
 */
import java.io.*;
import java.util.ArrayList;

public class UserManager {

    private static final String FILE_NAME = "users.txt";

    // Create users.txt if it doesn't exist
    static {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            try {
                file.createNewFile();

                // Create a default admin account
                PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true));
                writer.println("admin,123,Admin");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

 
    public static boolean addUser(User user) {

        if (usernameExists(user.getUsername())) {
            return false;
        }

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true));

            writer.println(user.toString());

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();

        }

        return false;
    }

   
    public static User login(String username, String password) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    if (data[0].equals(username) &&
                            data[1].equals(password)) {

                        reader.close();

                        return new User(data[0], data[1], data[2]);
                    }
                }

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;
    }

   
    public static boolean usernameExists(String username) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(username)) {

                    reader.close();

                    return true;

                }

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return false;

    }

   
    public static ArrayList<User> getAllUsers() {

        ArrayList<User> users = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    users.add(new User(data[0], data[1], data[2]));

                }

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return users;

    }

}
