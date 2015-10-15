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
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x, epsilon = 0.0001;
        while (Math.abs((r * r - x) / x) > epsilon) {
            r = (r + (x / r)) * 0.5;
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
            out.println("The answer: " + sqrt(num));
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
