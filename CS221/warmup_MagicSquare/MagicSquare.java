import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * MagicSquare implements the MagicSquareInterface and uses command-line arguments to either
 * read an array from a file, or create an array in a new file. Then it determines whether or not
 * the array is a valid Magic Square.
 * 
 * @author Amanda Halverson
 */

public class MagicSquare implements MagicSquareInterface {

    private int[][] magicSquare;
    private boolean isValidMagicSquare;

    /**
     * This MagicSquare constructor takes the name of a given file object from the command-line
     * and attaches a Scanner, which determines whether or not the file can be opened and is
     * in the correct format.
     * The inner readMatrix method uses a while loop to read the file line-by-line into
     * a 2D int array of the size indicated by the first line of the file.
     * 
     * If Scanner throws a FileNotFoundException when opening or reading the file, it displays
     * an error message, and exits the program.
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public MagicSquare(String filename) throws FileNotFoundException {
        
        //this.magicSquare;

        try {
            Scanner fileScan = new Scanner(filename);

            //takes filename, tries to read file - if can't read or not correct format, catch
            //if yes, use readMatrix
            
            readMatrix(filename);
            fileScan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File cannot be opened or is not in correct format");
            System.exit(0);
        }

        private int[][] readMatrix(String filename) throws FileNotFoundException {
            try {
                // Scanner lineScan = new Scanner(filename);
                // read first line to get n & initialize magicSquare[n][n]

                // for ( row ) {
                //     scanner line by line, then .getnextline,
                //     for (column) {
                //         use another scanner to getnextint
                //         put each i into arry
                //         use a lot of what other array creater does
                //     }
                // }
                lineScan.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Error: Cannot read file into array");
                System.exit(0);
            }
        }
    }

    /**
     * This MagicSquare constructor takes a string filename and an int dimension and uses a
     * for-loop to create a new 2D int array with the new dimension of nxn.
     * The inner writeMatrix method uses the filename to write the new array to a new file with
     * the given filename.
     * 
     * If an IOException occurs when creating the array or writing it to the new file,
     * it displays an error message, and exits the program.
     * 
     * @param filename
     * @param dimension
     * @throws IOException
     */
    public MagicSquare(String filename, int dimension) throws IOException {
        //this.MagicSquare = ;

        int n = dimension;
        int[][] array = new int[n][n];
        int row = n-1;
        int col = n/2;
        int oldRow;
        int oldCol;

        try {
            for (int i = 1; i == n*n; i++) {
                array[row][col] = array[i][i];
                oldRow = row;
                oldCol = col;
                row = row + 1;
                col = col + 1;

                if (row == n) {
                    row = 0;
                }
                if (col == n) {
                    col = 0;
                }
                if (array[i][i] != 0) {
                    row = oldRow;
                    col = oldCol;
                    row--;
                }
            magicSquare = array;
            writeMatrix (array, filename);
            }
        }
        catch (IOException e) {
            System.out.println("Error: Cannot create a matrix");
            System.exit(0);
        }
    }

        private void writeMatrix(int[][] matrix, String filename) throws IOException {
            
            try {
                File file = new File(filename);
                PrintWriter outFile = new PrintWriter(file);

                //for loop to loop through matrix rows and columns and use printwriter to
                // print into "file"

                outFile.close();
            }
            catch (IOException e) {
                System.out.println("Error: Cannot write matrix to file");
                System.exit(0);
            }
        }
    
    @Override
    public boolean isMagicSquare() {

        if ("do integers 1,2,3...n*n appear? && n (n*n +1) / 2") {
            isValidMagicSquare = true;
        }
        else {
            isValidMagicSquare = false;
        }
        return isValidMagicSquare;
    }

    @Override 
    public int[][] getMatrix() {
        return magicSquare;
    }

    @Override 
    public String toString() {
        boolean yesNo = isMagicSquare();
        String result = "The matrix \n";

        //formatted magicSquare (result += do two for loops to read the ints)

            result += magicSquare;

        if (yesNo == true) {
            System.out.println(result += "is a magic square.");
        }
        else {
            System.out.println(result += "is not a magic square.");
        }
        return result;
    }
}