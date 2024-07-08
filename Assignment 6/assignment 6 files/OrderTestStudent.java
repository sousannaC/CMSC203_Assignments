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