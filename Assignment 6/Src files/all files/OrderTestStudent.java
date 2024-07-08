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

import static org.junit.Assert.*;
import org.junit.Test;
import implementation.Order;

public class OrderTestStudent {

    @Test
    public void testConstructor() {
        Customer customer = new Customer("John", 25);
        Order order = new Order(12345, Day.MONDAY, customer);
        assertEquals(12345, order.getOrderNumber());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals(customer, order.getCustomer());
    }

}