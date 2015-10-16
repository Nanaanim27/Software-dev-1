import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program will prompt the user to enter a password that he or she would like, the password must satisfy
 * at least 3 of the 4 requirements and must be at least 6 characters in length. If the password does not meet the
 * full requirements it will say which requirements the password does not suffice.
 *
 * @author Jordan L. McMillan
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks if the given String contains a special character (ie
     * !@#$%^&*()_-+={}[]:;,.?).
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsSpecialChar(String s) {
        boolean hasSpecialChar = true;
        String specialChars = "!@#$%^&*()_-+={}[]:;,.?";
        int count = 0;
        for (int i = 0; i < specialChars.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == specialChars.charAt(i)) {
                    count++;
                    i = specialChars.length(); //first special char kicks out of loop
                    j = s.length();
                }
            }
        }
        if (count < 1) {
            hasSpecialChar = false;
        }
        return hasSpecialChar;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigit(String s) {
        boolean hasDigit = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count++;
                i = s.length(); //first digit kicks out of loop
            }
        }
        if (count < 1) {
            hasDigit = false;
        }
        return hasDigit;
    }

    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s, SimpleWriter out) {
        boolean hasLowerCaseLetter = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                count++;
                i = s.length(); //first lower case letter kicks out of loop
            }
        }
        if (count < 1) {
            hasLowerCaseLetter = false;
        }
        return hasLowerCaseLetter;
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean hasUpperCaseLetter = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
                i = s.length(); //first Upper case letter kicks out of loop
            }
        }
        if (count < 1) {
            hasUpperCaseLetter = false;
        }
        return hasUpperCaseLetter;
    }

    /**
     * Checks whether the given String satisfies the CSE department criteria for
     * a valid password. Prints an appropriate message to the given output
     * stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        int passwordRequirementTracker = 0; //counter to make sure the password has 3 of the 4 requirements
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        if (s.length() < 6) {
            out.println(
                    "Oops, password must be at least 6 characters in length, try again.");
        }
        if (containsUpperCaseLetter(s)) { // if true the upper case requirement was met
            passwordRequirementTracker++;
            hasUpperCase = true;
        }
        if (containsLowerCaseLetter(s, out)) { // if true the lower case requirement was met
            passwordRequirementTracker++;
            hasLowerCase = true;
        }
        if (containsDigit(s)) { // if true the digit requirement was met
            passwordRequirementTracker++;
            hasDigit = true;
        }
        if (containsSpecialChar(s)) { // if true the special char requirement was met
            passwordRequirementTracker++;
            hasSpecialChar = true;
        }
        if (passwordRequirementTracker < 3) {
            out.println(
                    "Oops, Your password must contain at least 3 of the 4 requirements.");
            if (!hasUpperCase) {
                out.println(
                        "Your password does not contain at least one upper case letter.");
            }
            if (!hasLowerCase) {
                out.println(
                        "Your password does not contain at least one lower case letter.");
            }
            if (!hasDigit) {
                out.println(
                        "Your password does not contain at least one digit.");
            }
            if (!hasSpecialChar) {
                out.println(
                        "Your password does not contain at least one special character.");
            }
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Please enter a password you would like to use: ");
        String passWord = in.nextLine();
        checkPassword(passWord, out);

        out.print("-End-");
        in.close();
        out.close();
    }

}
