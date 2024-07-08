/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: TwoDimRaggedArrayUtility class deals with  two-dimensional ragged arrays of doubles. 
 * HolidayBonus class deals with highest sales in a category, another for the store with the lowest sales in a 
 * category, and the third for all other stores.
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Sousanna Chugunova 
*/


package bonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    // Reads data from a file and returns a two-dimensional array of doubles.
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        double[][] array = new double[rows][];
        scanner = new Scanner(file);
        int row = 0;
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().trim().split(" ");
            array[row] = new double[tokens.length];
            for (int col = 0; col < tokens.length; col++) {
                array[row][col] = Double.parseDouble(tokens[col]);
            }
            row++;
        }
        return array;
    }

    // Writes the data from a two-dimensional array of doubles to a file.
    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : array) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    // Calculates and returns the total sum of all elements in the two-dimensional array.
    public static double getTotal(double[][] array) {
        double total = 0.0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Calculates and returns the average of all elements in the two-dimensional array.
    public static double getAverage(double[][] array) {
        int count = 0;
        double total = 0.0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
                count++;
            }
        }
        return total / count;
    }

    // Calculates and returns the total sum of elements in a specific row of the array.
    public static double getRowTotal(double[][] array, int rowIndex) {
        double total = 0.0;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (double value : array[rowIndex]) {
                total += value;
            }
        }
        return total;
    }

    // Calculates and returns the total sum of elements in a specific column of the array.
    public static double getColumnTotal(double[][] array, int colIndex) {
        double total = 0.0;
        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                total += row[colIndex];
            }
        }
        return total;
    }

    // Finds and returns the highest value in a specific row of the array.
    public static double getHighestInRow(double[][] array, int rowIndex) {
        double max = Double.MIN_VALUE;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (double value : array[rowIndex]) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    // Finds and returns the index of the highest value in a specific row of the array.
    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        double max = Double.MIN_VALUE;
        int maxIndex = -1;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (int i = 0; i < array[rowIndex].length; i++) {
                if (array[rowIndex][i] > max) {
                    max = array[rowIndex][i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    // Finds and returns the lowest value in a specific row of the array.
    public static double getLowestInRow(double[][] array, int rowIndex) {
        double min = Double.MAX_VALUE;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (double value : array[rowIndex]) {
                min = Math.min(min, value);
            }
        }
        return min;
    }

    // Finds and returns the index of the lowest value in a specific row of the array.
    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (int i = 0; i < array[rowIndex].length; i++) {
                if (array[rowIndex][i] < min) {
                    min = array[rowIndex][i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    // Finds and returns the highest value in a specific column of the array.
    public static double getHighestInColumn(double[][] array, int colIndex) {
        double max = Double.MIN_VALUE;
        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                max = Math.max(max, row[colIndex]);
            }
        }
        return max;
    }

    // Finds and returns the index of the highest value in a specific column of the array.
    public static int getHighestInColumnIndex(double[][] array, int colIndex) {
        double max = Double.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (colIndex >= 0 && colIndex < array[i].length) {
                if (array[i][colIndex] > max) {
                    max = array[i][colIndex];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    // Finds and returns the lowest value in a specific column of the array.
    public static double getLowestInColumn(double[][] array, int colIndex) {
        double min = Double.MAX_VALUE;
        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                min = Math.min(min, row[colIndex]);
            }
        }
        return min;
    }

    // Finds and returns the index of the lowest value in a specific column of the array.
    public static int getLowestInColumnIndex(double[][] array, int colIndex) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (colIndex >= 0 && colIndex < array[i].length) {
                if (array[i][colIndex] < min) {
                    min = array[i][colIndex];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    // Finds and returns the highest value in the entire array.
    public static double getHighestInArray(double[][] array) {
        double max = Double.MIN_VALUE;
        for (double[] row : array) {
            for (double value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    // Finds and returns the lowest value in the entire array.
    public static double getLowestInArray(double[][] array) {
        double min = Double.MAX_VALUE;
        for (double[] row : array) {
            for (double value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }
}
