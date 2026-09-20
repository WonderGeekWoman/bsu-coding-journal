import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The FormatChecker class evaluates the format of one or more input files,
 * as specified in the command-line arguments. Each file that is in the correct
 * format is declared VALID. Each file that is not in the correct format is
 * declared INVALID. All files passed in as command-line arguments are
 * evaluated and reported on at the end of the program.
 * 
 * A valid format contains exactly two whitespace-separated, positive integers
 * in the first row, specifying the number of rows and columns in a grid. Each
 * subsequent row represents one row of the grid and should contain exactly one
 * whitespace-separated double value for each grid column. For example:
 * 
 * 3 4
 * 2 4.7 -9.0 11.5
 * -45 3 78 6
 * 7.4 8 0 2000.0
 * 
 * An invalid file format is declared if the file cannot be found, if the
 * values don't match the expected data formats, or if there are fewer or more
 * rows and/or columns of data than specified in the first row. The program
 * checks the columns first, and if the columns are correct, it will verify
 * the rows. If the file is invalid, the program displays a short explanation,
 * either by an exception thrown while parsing, or a formatting problem
 * discovered by a condition check.
 * 
 * This program runs from the command line using the following format:
 * $ java FormatChecker file1 [file2 ... fileN]
 * where the names of one or more input files are given.
 * 
 * @author Amanda Halverson
 */

public class FormatChecker {

    /**
     * The main method that takes user-input and runs the program.
     * 
     * @param args from command-line
     * @throws FileNotFoundException  if the file is not found
     * @throws InPutMismatchException if the format of the data is incorrect
     * @throws NoSuchElementException if there are fewer rows than specified
     */
    public static void main(String[] args) {
        String filename = "";
        String result = "";
        String errorMsg = "";

        if (args.length == 0) {
            System.out.print("Usage: $ java FormatChecker file1 [file2 ... fileN]");
        }

        for (int i = 0; i < args.length; i++) {
            int rowsExpected = 0;
            int colsExpected = 0;
            int colTotal = 0;

            try {
                filename = args[i];
                File file = new File(args[i]);

                Scanner dimensionScan = new Scanner(file);
                rowsExpected = dimensionScan.nextInt();
                colsExpected = dimensionScan.nextInt();

                if (dimensionScan.nextLine().isEmpty()) {
                    for (int j = 0; j < rowsExpected; j++) {
                        colTotal = 0;
                        Scanner lineScan = new Scanner(dimensionScan.nextLine());
                        while (lineScan.hasNext()) {
                            lineScan.nextDouble();
                            colTotal++;
                        }
                        if ((colTotal == colsExpected)) {
                            result = "VALID";
                        } else {
                            result = "INVALID";
                            errorMsg = ("Error: At least one row in this file has either more or "
                                    + "fewer than the " + colsExpected + " columns specified.");
                            break;
                        }
                        lineScan.close();
                    }
                    if (result.equals("VALID")) {
                        if (dimensionScan.hasNextLine() && !dimensionScan.nextLine().isEmpty()) {
                            result = "INVALID";
                            errorMsg = ("Error: There are more rows in this file than the " +
                                    rowsExpected + " rows specified.");
                        }
                    }
                } else {
                    errorMsg = ("Error: The first row of this file does not have exactly two "
                            + "integers, as required.");
                }
                dimensionScan.close();
            } catch (FileNotFoundException e) {
                errorMsg = (e.toString());
                result = "INVALID";
            } catch (InputMismatchException e) {
                errorMsg = (e.toString() + ": " + filename + " (At least one of the values in "
                        + "this file is not in the correct format)");
                result = "INVALID";
            } catch (NoSuchElementException e) {
                errorMsg = (e.toString() + ": " + filename + " (There are fewer rows in this file "
                        + "than the " + rowsExpected + " rows specified)");
                result = "INVALID";
            } finally {
                System.out.println(filename);
                if (result.equals("INVALID")) {
                    System.out.println(errorMsg);
                }
                System.out.println(result + "\n");
                errorMsg = "";
            }
        }
    }
}