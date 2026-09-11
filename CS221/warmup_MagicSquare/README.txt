******************
* Magic Square
* CS 221
* 9/8/2026
* Amanda Halverson
******************

OVERVIEW:

 Magic Square is a program that takes in either an existing filename or a new filename and an
 odd positive integer to read or create a matrix, test the matrix to find out if it is a magic
 square, then prints the result to the console.


INCLUDED FILES:

 MagicSquareDriver.java - source file
 MagicSquare.java - source file
 MagicSquareInterface - source file
 MagicSquareTest.java - source file
 README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the driver class (and all dependencies)
 with the command:
 $ java MagicSquareDriver.java

 To test an existing file with a matrix enter the command:
 $ java MagicSquareDriver -check <filename.txt>

 To create and test a new matrix and file enter the command:
 $ java MagicSquareDriver -create <filename.txt> <size>

 Console output will report the result after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 A magic square is a matrix of size n x n that has the values 1, 2, 3,...n^2 where the sum of each
 row, each column, and both diagonals is the same. MagicSquare implements the MagicSquareInterface,
 which defines methods to get the matrix, test if it is a magic square and print the result.

 MagicSquareDriver reads the user input and decides which constructor in MagicSquare to use. If the
 user inputs an even or negative integer with the -create flag, the program prompts the user to try
 again. After the program has run, the result is printed in the console.

 MagicSquare has two constructors that are used depending on the input from the user. If the user
 provides the -check flag, and the name of an existing file, the first constructor attempts to open
 the file. If it cannot find the file or if it is the wrong type, it will exit the program. Otherwise,
 it will read the file line-by-line and create a 2D matrix array. Then it will test the matrix against
 the requirements of a magic square, using the isMagicSquare() method and report the result.

 If the user provides the -create flag, a new file name with the correct .txt file type, and an odd
 positive integer, the second constructor in MagicSquare takes the integer (n) and creates a matrix
 array of size n x n. It reads the new matrix into the new file name, tests the matrix using the
 isMagicSquare() method and reports the result.

 The result is printed in a format specified in the toString() method, printing a visual representation
 of the matrix and reporting if it is or is not a magic square.


TESTING:

 I did not test my program because it is incomplete.


DISCUSSION:

 The biggest issue I encountered during programming was time management and the inability to get help
 from tutors due to my tight class and work schedule. I struggled to remember how to write Java code,
 but once I figured out what I would need to write for any section, I mostly remembered what project I
 had seen it used in and could reference either CS121 examples and slides or my own code. The parts I
 struggled with the most remain unwritten. I found it all a challenge, but I love a challenge and will
 use my time differently every day to provide time to work on my CS221 projects.