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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoffeeTestStudent {

    @Test
    public void testCalcPriceWithoutExtras() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, false, false);
        assertEquals(2.0, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithExtraShot() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        assertEquals(3.0, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithExtraSyrup() {
        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, false, true);
        assertEquals(3.75, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithExtras() {
        Coffee coffee = new Coffee("Mocha", Size.SMALL, true, true);
        assertEquals(3.25, coffee.calcPrice(), 0.01);
    }
}
