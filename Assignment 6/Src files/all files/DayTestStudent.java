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

public class DayTestStudent {

    @Test
    public void testEnumValues() {
        assertEquals("MONDAY", Day.MONDAY.toString());
        assertEquals("TUESDAY", Day.TUESDAY.toString());
        assertEquals("WEDNESDAY", Day.WEDNESDAY.toString());
        assertEquals("THURSDAY", Day.THURSDAY.toString());
        assertEquals("FRIDAY", Day.FRIDAY.toString());
        assertEquals("SATURDAY", Day.SATURDAY.toString());
        assertEquals("SUNDAY", Day.SUNDAY.toString());
    }
}
