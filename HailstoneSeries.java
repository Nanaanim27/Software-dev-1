import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program will ask the user to input a postitive integer and then it will
 * calcuate the hailstone series
 *
 * @author Jordan Lance McMillan
 *
 */
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer and outputs the length of the hailstone series as well as the
     * highest integer in the series
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int count = 0, max = 0;
        while (n != 1) {
            if (n % 2 == 0) { // if even number
                count++;
                n = n / 2;
            } else { //odd number
                count++;
                n = 3 * n + 1;
            }
            if (n > max) {
                max = n;
            }
            out.print(n + ", ");
        }
        out.println();
        out.println("The length of the hailstone series is: " + count);
        out.println("The maximum number in the hailstone series is: " + max);
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
            out.print(
                    "Enter a positive number to start the hailstone series calculations: ");
            int num = in.nextInteger();
            generateSeries(num, out);
            out.println(
                    "Do you wish to calculate another Hailstone series?(enter 'y')");
            String answer = in.nextLine();
            if (!answer.equals("y")) {
                out.print("You've quit.");
                ask = false;
            }
        }
        in.close();
        out.close();
    }
}
