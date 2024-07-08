/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Make an order with three different types of beverage choice options
 * Due: 04/29/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sousanna Chugunova
*/



package implementation;

import org.junit.Test;
import static org.junit.Assert.*;

public class SmoothieTestStudent {

    @Test
    public void testCalcPriceWithoutProteinAndFruits() {
        Smoothie smoothie = new Smoothie("Banana Smoothie", null, Size.SMALL, 0, false);
        assertEquals(3.0, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithProteinAndFruits() {
        Smoothie smoothie = new Smoothie("Berry Smoothie", null, Size.MEDIUM, 3, true);
        assertEquals(7.0, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Pineapple Smoothie", null, Size.LARGE, 2, false);
        String expectedString = "Smoothie: Pineapple Smoothie, Size: LARGE, Protein Added: false, Number of Fruits: 2";
        assertEquals(expectedString, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Banana Smoothie", null, Size.SMALL, 1, true);
        Smoothie smoothie2 = new Smoothie("Banana Smoothie", null, Size.SMALL, 1, true);
        assertEquals(smoothie1, smoothie2);
    }
}
