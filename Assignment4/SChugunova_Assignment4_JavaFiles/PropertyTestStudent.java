/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Plot Class: Implement methods for x, y, width, and depth fields in the Plot class.
PlotTestStudent: Write JUnit test methods for public Plot class methods.
Property Class: Define fields for property name, city, rent, owner, and plot in Property class.
PropertyTestStudent: Develop JUnit tests for Property class public methods.
ManagementCompany Class: Create fields for company name, tax ID, fee percentage, properties, and plot in ManagementCompany class.
ManagementCompanyTestStudent: Construct JUnit tests for ManagementCompany class methods.
 * Due: 04/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sousanna Chugunova
*/

package assignment; 
import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testSetPropertyName() {
        Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        property.setPropertyName("New Property Name");
        assertEquals("New Property Name", property.getPropertyName());
    }

    @Test
    public void testSetRentalAmount() {
        Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        property.setRentAmount(3000.00);
        assertEquals(3000.00, property.getRentAmount(), 0.01);
    }
    
    @Test
    public void testSetPlot() {
        Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        property.setPlot(new Plot(1, 1, 2, 2));
        assertEquals(1, property.getPlot().getX());
        assertEquals(1, property.getPlot().getY());
        assertEquals(2, property.getPlot().getWidth());
        assertEquals(2, property.getPlot().getDepth());
    }

    @Test
    public void testEquals() {
        Property property1 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        Property property2 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        assertTrue(property1.equals(property2));
    }
    
    @Test
    public void testHashCode() {
        Property property1 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        Property property2 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        assertEquals(property1.hashCode(), property2.hashCode());
    }
    
    @Test
    public void testToString() {
        Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0", property.toString());
    }
    @Test
    public void testSetPropertyCity() {
        Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 0, 0, 0, 0);
        property.setCity("New City");
        assertEquals("New City", property.getCity());
    }
}
