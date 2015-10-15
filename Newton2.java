import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program will calculate the square root of a number using Newton
 * iteration
 *
 * @author Jordan Lance McMillan
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt1(double x, SimpleWriter out) {
        double r = x, epsilon = 0.0001;
        int guess = 1; //track of the number of guesses
        if (x != 0.0) {
            while (Math.abs((r * r - x) / x) > epsilon) {
                out.println("Guess #" + guess + " r: " + r + " x: " + x); // output statement to track the method's guesses
                r = (r + (x / r)) * 0.5;
                guess++;
            }
        }
        return r;
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

        boolean ask = true;
        while (ask) {
            out.print("Enter a positive double: ");
            double num = in.nextDouble();
            out.println("The answer: " + sqrt1(num, out));
            out.println("Do you wish to calculate another? ('y' or 'n')");
            String answer = in.nextLine();
            if (!answer.equals("y")) {
                ask = false;
            }
        }
        out.print("You have quit.");
        in.close();
        out.close();
    }

}
