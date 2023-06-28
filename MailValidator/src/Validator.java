import java.util.Arrays;
import java.util.NoSuchElementException;

public class Validator {

    /**
     * Validates e-mail address. Checks if this not null or empty.
     * Checks if the e-mail address has correct chars sequence.
     *
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail address valid, false if not.
     */
    public static boolean isValid(String email) {
        if (email == null || email.isBlank()) {
            throw new NullPointerException("ERROR: E-Mail address cannot be null or empty!");
        }

        String cleanMail = email.trim();

        if (!containsMailSign(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain or has to many '@' signs!");
        }
        //TODO: @ counter extrachieren

        if (!isUsernameValid(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not start with valid username!");
        }

        if (!isDomainValid(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain valid domain name!");
        }

        if (!isRootDomainValid(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain valid root domain!");
        }

        return true;
    }

    /**
     * Validates whether the string contains "@" sign.
     * Verify that "@" sign count == 1.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail contains valid "@" sign, false if not.
     */
    private static boolean containsMailSign(String email) {
        int count = 0;
                //email.length() - email.replace("@", "").length();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }

        return count == 1;
    }

    /**
     * Validates whether the username contains at least 3 chars before @ sign.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail starts with at least 3 chars before @, false if not.
     */
    private static boolean isUsernameValid(String email) {
        String[] splittEmail = email.split("@");
        return splittEmail[0] != null && splittEmail[0].length() >= 3;
    }

    /**
     * Validates whether the domain name contains at least 3 chars after @ sign.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail starts with at least 3 chars after @, false if not.
     */
    private static boolean isDomainValid(String email) {
        String[] splittEmail = email.split("@");
        if (splittEmail != null && splittEmail.length == 2) {

            String domainPart = splittEmail[1];
            if (domainPart.charAt(0) != '.'
                    && domainPart.charAt(domainPart.length()-1) != '.') {

                //TODO: validate duplicates of ".". I.E. ".."
                String[] domainParts = domainPart.split("\\.");
                if (domainParts != null && domainParts.length > 1) {

                    String rootDomain = domainParts[domainParts.length - 2];
                    return rootDomain.length() >= 3;
                }
            }
        }
        return false;
    }

    /**
     * Validates whether the end of the given email address contains "."
     * and at least 2 chars.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail contains valid "."
     * and at least 2 chars at the end, false if not.
     */
    private static boolean isRootDomainValid(String email) {
        String[] splittEmail = email.split("@");
        if (splittEmail != null && splittEmail.length == 2) {

            String domainPart = splittEmail[1];
            if (domainPart.charAt(0) != '.'
                    && domainPart.charAt(domainPart.length()-1) != '.') {

                //TODO: validate duplicates of ".". I.E. ".."
                String[] domainParts = domainPart.split("\\.");
                if (domainParts != null && domainParts.length > 1) {

                    String rootDomain = domainParts[domainParts.length - 1];
                    // searches for ".de" or ".org" or ".store"
                    return rootDomain.length() >= 2;
                }
            }
        }

        return false;
    }
}
