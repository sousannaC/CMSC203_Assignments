package implementation;

import org.junit.Test;
import static org.junit.Assert.*;



public class CustomerTestStudent {

    @Test
    public void testConstructorAndGetters() {
        Customer customer = new Customer("John", 30);
        assertEquals("John", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer originalCustomer = new Customer("Alice", 25);
        Customer copiedCustomer = new Customer(originalCustomer);
        assertEquals(originalCustomer.getName(), copiedCustomer.getName());
        assertEquals(originalCustomer.getAge(), copiedCustomer.getAge());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("Bob", 35);
        customer.setName("Charlie");
        assertEquals("Charlie", customer.getName());
    }

    @Test
    public void testSetAge() {
        Customer customer = new Customer("David", 40);
        customer.setAge(45);
        assertEquals(45, customer.getAge());
    }
    
}
