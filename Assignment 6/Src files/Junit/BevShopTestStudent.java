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

public class BevShopTestStudent {

    @Test
    public void testIsValidTime() {
        BevShop bevShop = new BevShop();
        assertTrue(bevShop.isValidTime(10)); // Assuming MIN_TIME is 0 and MAX_TIME is 23
        assertFalse(bevShop.isValidTime(-1));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        BevShop bevShop = new BevShop();
        assertEquals(5, bevShop.getMaxNumOfFruits()); // Assuming MAX_FRUIT is 5
    }

}
