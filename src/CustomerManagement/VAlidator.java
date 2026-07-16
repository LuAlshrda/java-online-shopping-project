
package CustomerManagement;

/**
Empty fields
Phone number format
Email format
Duplicate customer IDs
 */
public class VAlidator{

    //check if a text field is empty
    public static boolean isEmpty(String text){
        return text == null || text.trim().isEmpty();
    }

    //check if phone contains only numbers
    public static boolean isValidPhone(String phone){

        if (isEmpty(phone)){
            return false;
        }

        for (int i = 0; i < phone.length(); i++){
            if (!Character.isDigit(phone.charAt(i))){
                return false;
            }
        }

        return true;
    }

    //email validation
    public static boolean isValidEmail(String email){

        if (isEmpty(email)) {
            return false;
        }

        return email.contains("@") && email.contains(".");
    }

    //check if registration date is entered
    public static boolean isValidDate(String date){
        return !isEmpty(date);
    }
}
