
/**
 * Depending on user input, MagicSquareDriver checks a file for a matrix, and whether it is a magic
 * square, then prints the result. Or it creates a new odd-numbered matrix in a new file with the
 * name provided by the user, then checks whether it is a magic square and prints the result.
 * 
 * @author Amanda Halverson
 */

public class MagicSquareDriver {
    
    public static void main(String[] args) {
        
        String flag = args[0];
        String fileName = args[1];
        int size;

        if (flag == "-check") {
            int[][] checkMatrix = MagicSquare.MagicSquare(fileName);
            System.out.println(checkMatrix);
        }
        if (flag == "-create") {
            try {
                size = Integer.parseInt(args[2]);
                if (size % 2 != 1) {
                    int[][] newMatrix = MagicSquare.MagicSquare(fileName, size);
                    System.out.println(newMatrix);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Size must be odd positive integer, please try again.");
                System.exit(1);
            }
        }
        else {
            System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename>< |size>");
            System.exit(0);
        }
    }
}
