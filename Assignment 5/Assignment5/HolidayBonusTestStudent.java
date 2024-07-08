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
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        // Test case 1: Test with no sales
        double[][] sales1 = {{}, {}, {}};
        double[] expected1 = {0.0, 0.0, 0.0};
        assertArrayEquals(expected1, HolidayBonus.calculateHolidayBonus(sales1), 0.01);

        // Test case 2: Test with one store with highest and lowest sales
        double[][] sales2 = {{100.0}, {200.0}, {100.0}};
        double[] expected2 = {50.0, 100.0, 50.0};
        assertArrayEquals(expected2, HolidayBonus.calculateHolidayBonus(sales2), 0.01);

        // Test case 3: Test with multiple stores with different sales
        double[][] sales3 = {{100.0, 200.0, 300.0}, {200.0, 300.0, 400.0}};
        double[] expected3 = {75.0, 75.0};
        assertArrayEquals(expected3, HolidayBonus.calculateHolidayBonus(sales3), 0.01);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        // Test case 1: Test with no sales
        double[][] sales1 = {{}, {}, {}};
        assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(sales1), 0.01);

        // Test case 2: Test with sales
        double[][] sales2 = {{100.0, 200.0, 300.0}, {200.0, 300.0, 400.0}};
        assertEquals(150.0, HolidayBonus.calculateTotalHolidayBonus(sales2), 0.01);
    }
}
