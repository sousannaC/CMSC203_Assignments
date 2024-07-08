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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MgmCompanyTestStudent {
    Property sampleProperty;
    MgmCompany managementCo;

    @Before
    public void setUp() throws Exception {
        managementCo = new MgmCompany("Railey", "555555555", 6);
    }

    @After
    public void tearDown() throws Exception {
        managementCo = null;
    }

    @Test
    public void testAddProperty() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 0, 0);
        assertEquals(0, managementCo.addProperty(sampleProperty));
    }

    @Test
    public void testGetTotalRent() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        assertEquals(2613.0, managementCo.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        assertEquals(sampleProperty, managementCo.getHighestRentProperty());
    }

    @Test
    public void testRemoveLastProperty() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson");
        managementCo.addProperty(sampleProperty);
        managementCo.removeLastProperty();
        assertEquals(0, managementCo.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(managementCo.isPropertiesFull());
        for (int i = 0; i < 6; i++) {
            Property property = new Property("Property" + i, "Location" + i, 1000.0 * i, "Owner" + i);
            managementCo.addProperty(property);
        }
        assertTrue(managementCo.isPropertiesFull());
    }

    @Test
    public void testGetPropertiesCount() {
        assertEquals(0, managementCo.getPropertiesCount());
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson");
        managementCo.addProperty(sampleProperty);
        assertEquals(1, managementCo.getPropertiesCount());
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(managementCo.isManagementFeeValid());
        managementCo.setManagementFeePercentage(101);
        assertFalse(managementCo.isManagementFeeValid());
    }

    @Test
    public void testToString() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        String expectedString = "List of the properties for Railey, taxID: 555555555\n"
                + "______________________________________________________\n"
                + "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
                + "______________________________________________________\n\n"
                + " total management Fee: 156.78";
        assertEquals(expectedString, managementCo.toString());
    }

    @Test
    public void testRemovePropertyByIndex() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        assertTrue(managementCo.removeProperty(0));
        assertEquals(0, managementCo.getPropertiesCount());
    }

    @Test
    public void testGetAverageRent() {
        assertEquals(0.0, managementCo.getAverageRent(), 0.001);
        sampleProperty = new Property("Sunsational", "Beckman", 2000, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        sampleProperty = new Property("Ambiance", "Lakewood", 3000, "Tammy Taylor", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        assertEquals(2500.0, managementCo.getAverageRent(), 0.001);
    }

    @Test
    public void testPropertyExists() {
        assertFalse(managementCo.propertyExists("Sunsational"));
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        assertTrue(managementCo.propertyExists("Sunsational"));
    }

    @Test
    public void testGetPropertiesAboveRent() {
        sampleProperty = new Property("Sunsational", "Beckman", 2000, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        sampleProperty = new Property("Ambiance", "Lakewood", 3000, "Tammy Taylor", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        Property[] aboveThreshold = managementCo.getPropertiesAboveRent(2500);
        assertEquals(1, aboveThreshold.length);
        assertEquals("Ambiance", aboveThreshold[0].getPropertyName());
    }

    @Test
    public void testGetPropertiesInCity() {
        sampleProperty = new Property("Sunsational", "Beckman", 2000, "BillyBob Wilson", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        sampleProperty = new Property("Ambiance", "Lakewood", 3000, "Tammy Taylor", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        sampleProperty = new Property("Bear Creek Lodge", "Peninsula", 4000, "Bubba Burley", 0, 0, 0, 0);
        managementCo.addProperty(sampleProperty);
        Property[] inCity = managementCo.getPropertiesInCity("Lakewood");
        assertEquals(1, inCity.length);
        assertEquals("Ambiance", inCity[0].getPropertyName());
    }
    {

    	// Programmer Name: Sousanna Chugunova
        System.out.print("Programmer Name: Sousanna Chugunova");
    }
}