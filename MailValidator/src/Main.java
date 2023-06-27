import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // check for null
        try {
            Validator.isValid(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        // check for empty
        try {
            Validator.isValid(" ");
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        // check for @ - valid
        try {
            System.out.println("Valid mail: " + Validator.isValid("asfasdfasfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        // check for @ - valid
        try {
            System.out.println("Valid mail: " + Validator.isValid("asfasdf@asfsadf.de"));
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}