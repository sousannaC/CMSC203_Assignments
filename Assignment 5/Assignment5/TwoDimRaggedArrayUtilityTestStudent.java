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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testArray;

    @Before
    public void setUp() {
        // Initialize test array
        testArray = new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
    }

    @After
    public void tearDown() {
        // Clean up test array
        testArray = null;
    }

    @Test
    public void testReadFile() {
        // Test reading from file
        try {
            File file = new File("test.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.println("1.0 2.0 3.0");
            writer.println("4.0 5.0");
            writer.println("6.0 7.0 8.0 9.0");
            writer.close();

            double[][] result = TwoDimRaggedArrayUtility.readFile(file);
            assertArrayEquals(testArray, result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteToFile() {
        // Test writing to file
        try {
            File file = new File("test.txt");
            TwoDimRaggedArrayUtility.writeToFile(testArray, file);

            double[][] result = TwoDimRaggedArrayUtility.readFile(file);
            assertArrayEquals(testArray, result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTotal() {
        // Test calculating total
        double expectedTotal = 1.0 + 2.0 + 3.0 + 4.0 + 5.0 + 6.0 + 7.0 + 8.0 + 9.0;
        double result = TwoDimRaggedArrayUtility.getTotal(testArray);
        assertEquals(expectedTotal, result, 0.001);
    }

    @Test
    public void testGetAverage() {
        // Test calculating average
        double expectedAverage = (1.0 + 2.0 + 3.0 + 4.0 + 5.0 + 6.0 + 7.0 + 8.0 + 9.0) / 9;
        double result = TwoDimRaggedArrayUtility.getAverage(testArray);
        assertEquals(expectedAverage, result, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        // Test calculating total for a specific row
        double expectedRowTotal = 4.0 + 5.0;
        double result = TwoDimRaggedArrayUtility.getRowTotal(testArray, 1);
        assertEquals(expectedRowTotal, result, 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        // Test calculating total for a specific column
        double expectedColumnTotal = 3.0 + 5.0 + 8.0;
        double result = TwoDimRaggedArrayUtility.getColumnTotal(testArray, 2);
        assertEquals(expectedColumnTotal, result, 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        // Test finding the highest value in a specific row
        double expectedHighest = 6.0;
        double result = TwoDimRaggedArrayUtility.getHighestInRow(testArray, 2);
        assertEquals(expectedHighest, result, 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        // Test finding the index of the highest value in a specific row
        int expectedHighestIndex = 2;
        int result = TwoDimRaggedArrayUtility.getHighestInRowIndex(testArray, 2);
        assertEquals(expectedHighestIndex, result);
    }

    @Test
    public void testGetLowestInRow() {
        // Test finding the lowest value in a specific row
        double expectedLowest = 4.0;
        double result = TwoDimRaggedArrayUtility.getLowestInRow(testArray, 1);
        assertEquals(expectedLowest, result, 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        // Test finding the index of the lowest value in a specific row
        int expectedLowestIndex = 0;
        int result = TwoDimRaggedArrayUtility.getLowestInRowIndex(testArray, 1);
        assertEquals(expectedLowestIndex, result);
    }

    @Test
    public void testGetHighestInColumn() {
        // Test finding the highest value in a specific column
        double expectedHighest = 7.0;
        double result = TwoDimRaggedArrayUtility.getHighestInColumn(testArray, 1);
        assertEquals(expectedHighest, result, 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        // Test finding the index of the highest value in a specific column
        int expectedHighestIndex = 2;
        int result = TwoDimRaggedArrayUtility.getHighestInColumnIndex(testArray, 1);
        assertEquals(expectedHighestIndex, result);
    }

    @Test
    public void testGetLowestInColumn() {
        // Test finding the lowest value in a specific column
        double expectedLowest = 2.0;
        double result = TwoDimRaggedArrayUtility.getLowestInColumn(testArray, 0);
        assertEquals(expectedLowest, result, 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        // Test finding the index of the lowest value in a specific column
        int expectedLowestIndex = 0;
        int result = TwoDimRaggedArrayUtility.getLowestInColumnIndex(testArray, 0);
        assertEquals(expectedLowestIndex, result);
    }

    @Test
    public void testGetHighestInArray() {
        // Test finding the highest value in the entire array
        double expectedHighest = 9.0;
        double result = TwoDimRaggedArrayUtility.getHighestInArray(testArray);
        assertEquals(expectedHighest, result, 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        // Test finding the lowest value in the entire array
        double expectedLowest = 1.0;
        double result = TwoDimRaggedArrayUtility.getLowestInArray(testArray);
        assertEquals(expectedLowest, result, 0.001);
    }
}


