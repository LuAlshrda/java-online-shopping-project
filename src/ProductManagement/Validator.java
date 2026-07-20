
package ProductManagement;

public class Validator {

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // it the  price is valid
    public static boolean isValidPrice(String price) {

        if (isEmpty(price)) {
            return false;
        }

        try {
            double p = Double.parseDouble(price);
            return p >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //if the  quantity is valid or not 
    public static boolean isValidQuantity(String quantity) {

        if (isEmpty(quantity)) {
            return false;
        }

        try {
            int q = Integer.parseInt(quantity);
            return q >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

   
    public static boolean isValidProductID(String id) {
        return !isEmpty(id);
    }

   
    public static boolean isValidProductName(String name) {
        return !isEmpty(name);
    }

 
    public static boolean isValidCategory(String category) {
        return !isEmpty(category);
    }

  
    public static boolean isValidBrand(String brand) {
        return !isEmpty(brand);
    }

    // Check if Description is entered
    public static boolean isValidDescription(String description) {
        return !isEmpty(description);
    }
}
