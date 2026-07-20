
package ProductManagement;

/**
 *
 * @author lujai
 */
public class Validator {

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // Check if price is valid
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

    // Check if quantity is valid
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

    // Check if Product ID is entered
    public static boolean isValidProductID(String id) {
        return !isEmpty(id);
    }

    // Check if Product Name is entered
    public static boolean isValidProductName(String name) {
        return !isEmpty(name);
    }

    // Check if Category is entered
    public static boolean isValidCategory(String category) {
        return !isEmpty(category);
    }

    // Check if Brand is entered
    public static boolean isValidBrand(String brand) {
        return !isEmpty(brand);
    }

    // Check if Description is entered
    public static boolean isValidDescription(String description) {
        return !isEmpty(description);
    }
}
