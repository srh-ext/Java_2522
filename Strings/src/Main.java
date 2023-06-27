import java.util.Arrays;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world";
        System.out.println(text.length());

        System.out.println(text.isEmpty());
        String leer = "";
        System.out.println(leer.isEmpty());

        String leerzeiche = " ";
        System.out.println(leerzeiche.isEmpty());   //false
        System.out.println(leerzeiche.isBlank());   //true
        System.out.println("##########################");
        String keinObject = null;
        System.out.println(leerzeiche.isBlank());
        //System.out.println(keinObject.isEmpty()); // NullPointer

        String trim = " Hallo ";
        System.out.println("'" + trim + "' length: " + trim.length());
        System.out.println("'" + trim.trim() + "' length: " + trim.trim().length());

        String split = "Hallo zusammen, heute ist ein schöner Tag!";
        String[] gesplittet = split.split(",");
        System.out.println(Arrays.toString(gesplittet));
        System.out.println(gesplittet[0]);

        String[] gesplittet2 = split.split(" ");
        System.out.println(Arrays.toString(gesplittet2));

        System.out.println("Hallo Yuriy, dein Name ist Beck.");
        String firstname = "Yuriy";
        String lastname = "Beck";
        System.out.println("Hallo " + firstname + ", dein Name ist " + lastname + ".");

        String name = "Hallo %s, dein Name ist %s.".formatted(firstname, lastname);
        System.out.println(name);

        String welcomeMsg = "\nHallo %s, dein Name ist %s.\nHeute ist ein schöner Tag - %b.";
        boolean wether = true;
        String name2 = String.format(welcomeMsg, firstname, lastname, wether);
        System.out.println(name2);

        String name3 = String.format(welcomeMsg, "GROSS\n", lastname, wether);
        System.out.println(name3);

        welcomeMsg += "\nIch bin %d.";
        int age = 36;
        String name4 = String.format(welcomeMsg, firstname, lastname, wether, age);
        System.out.println(name4);

        // %d - decial
        // %f - float
        // %s - String
        // %b - boolean
        // %c - ascii chars

        //Find a character at
        System.out.println(lastname.charAt(0));
        System.out.println(lastname.charAt(lastname.length()-1));

        System.out.println(lastname.substring(1));
        System.out.println(lastname.substring(1,lastname.length()-1));

        String sonderzeichen = "schön";
        System.out.println(sonderzeichen.replace("ö", "oe"));

        String registeredEmail = "Yuriy.Beck@SOLOCOM.org";
        String loginEmail = "yuriy.beck@solocom.org";
        System.out.println(registeredEmail.equals(loginEmail));
        System.out.println(registeredEmail.toLowerCase());
        System.out.println(registeredEmail.toLowerCase().equals(loginEmail));

        System.out.println(registeredEmail.toUpperCase());

        String mailSign = "@";
        String rootDomain = ".org";
        //3@3.2
        System.out.println(loginEmail.contains(mailSign));
        System.out.println(registeredEmail.toUpperCase().contains(rootDomain));
        System.out.println(registeredEmail.toLowerCase().contains(rootDomain));
        System.out.println(registeredEmail.toLowerCase().contains(mailSign.toUpperCase()));


        //if:else short version
        System.out.println("========== IF-ELSE SHORT VERSION ===========");
        boolean isMail = (loginEmail.contains(mailSign)) ? true : false;
        isMail = loginEmail.contains(mailSign);
        System.out.println(isMail);

        int i = (2023 > 10) ? 1 : 0;

        System.out.println("========== IF-ELSE VALIDATON ===========");
        String wrongMail = null;
        System.out.println(isMail1(wrongMail));
        System.out.println(isMail2(wrongMail));
        System.out.println(isMail(wrongMail));
        System.out.println(isMailCatchException(wrongMail));

        try {
            System.out.println(isMailCForwardException(wrongMail));
        } catch (NullPointerException | IndexOutOfBoundsException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }

        try {
            System.out.println(isMailOwnException(wrongMail));
        } catch (Exception ex) {
            System.out.println("WARN: " + ex.getMessage());
            System.out.println(ex.getStackTrace());
            System.out.println(ex.getClass());


            if (ex.getClass().equals(NullPointerException.class)) {
                System.out.println("Unser Log: " + Arrays.toString(ex.getStackTrace()));
                System.out.println("An den Kunden: "+ex.getMessage());
            }
        }
    }


    public static boolean isMail(String mailAddress) {
        //sinnlose Variante
        if (mailAddress != null && mailAddress.contains("@")) {
            return true;
        }
        return false;
    }

    public static boolean isMail1(String mailAddress) {
        if (mailAddress == null) return false;

        return mailAddress.contains("@");
    }

    /**
     *
     * @param mailAddress
     * @return
     */
    public static boolean isMail2(String mailAddress) {
        //comment
        return (mailAddress != null) && mailAddress.contains("@");
    }

    public static boolean isMailCatchException(String mailAddress) {
        try {
            if (mailAddress.contains("@")) {
                return true;
            }
        } catch (NullPointerException ex) {
            System.out.println("ERROR: das Object ist null");
            System.out.println("ERROR: " + ex.getMessage());
        }

        return false;
    }

    public static boolean isMailCForwardException(String mailAddress) throws NullPointerException {
        if (mailAddress.contains("@")) {
            return true;
        }

        return false;
    }

    public static boolean isMailOwnException(String mailAddress) throws NullPointerException {
        if (mailAddress != null && mailAddress.contains("@")) {
            return true;
        } else {
            throw new NullPointerException("Das Feld Mail-Address darf nicht leer sein!");

            //throw  new MyException("EN");
        }
    }
}