import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * FormatChecker reads the contents of files given by the user one-by-one and decides whether or
 * not that file contains a correctly-formatted array where the first row contains two
 * whitespace-separated positive integers, indicating how many rows and columns the array should
 * have, and subsequent rows represent one row of the grid and contain one whitespace-separated
 * double value for each grid column. For example:
 * 
 * 4 3
 * 2 4.7 -2
 * 44 3.7 6
 * 7.4 9 0
 * 
 * If a file does not have correctly formatted data, FormatChecker prints any exception messages
 * and declares the file "invalid". Otherwise, it prints the file name and declares it "valid".
 * 
 * @author Amanda Halverson
 * 
 */

public class FormatChecker {

    public static void main(String[] args) {
        String filename = "";
        String result = "";

        if (args.length == 0) {
            System.out.println("Error: Please provide at least one filename.");
            System.exit(0);
        }
        while (args.length != 0) {
            int n = 0;
            int m = 0;
            Scanner dimensions = null;

            try {
                for (int i = 0; i > args.length; i++) {
                    dimensions = new Scanner(args[i]);
                    n = dimensions.nextInt();
                    m = dimensions.nextInt();
                    int[][] checkArray = new int[n][m];


                }
            }
            catch (FileNotFoundException e) {
                result = "INVALD";
                System.out.println(e.toString());
            }
            catch (NumberFormatException e) {
                result = "INVALD";
                System.out.println(e.toString());
            }
            catch (InputMismatchException e) {
                result = "INVALD";
                System.out.println(e.toString());
            }
            catch (Exception e) {
                result = "INVALD";
                System.out.println(e.toString());
            }
            finally {
                if (dimensions != null) {
                dimensions.close();
                }
            }
        }
    }
}