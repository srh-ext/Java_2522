import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        //1 check for null
        try {
            Validator.isValid(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        //2 check for empty
        try {
            Validator.isValid(" ");
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        //3 check for @ - valid
        try {
            System.out.println("Valid mail: " + Validator.isValid("asfasdfasfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //4 check for @ - valid
        try {
            System.out.println("Valid mail: " + Validator.isValid("asfasdf@asfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //5 check for @ duplicates - not valid
        try {
            System.out.println("NOT Valid mail: " + Validator.isValid("asfa@sdf@asfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //6 check username - too short
        try {
            System.out.println("NOT Valid mail: " + Validator.isValid("as@asfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //7 check username - too short
        try {
            System.out.println("NOT Valid mail: " + Validator.isValid("@asfsadf.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //8 check domain - too short
        try {
            System.out.println("NOT Valid mail: " + Validator.isValid("asdfsa@as.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //9 check domain - valid
        try {
            System.out.println("Valid mail: " + Validator.isValid("asdfsa@als.de"));
        } catch (NullPointerException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }
}