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

public class SizeTestStudent {

    @Test
    public void testEnumValues() {
        assertEquals("SMALL", Size.SMALL.toString());
        assertEquals("MEDIUM", Size.MEDIUM.toString());
        assertEquals("LARGE", Size.LARGE.toString());
    }
}
