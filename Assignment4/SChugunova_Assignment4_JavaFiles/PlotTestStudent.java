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

public class PlotTestStudent {
    @Test
    public void testOverlaps_ShouldReturnTrue_WhenPlotsOverlap() {
        Plot plot1 = new Plot(2, 2, 6, 6);
        Plot plot2 = new Plot(3, 4, 4, 3);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    public void testOverlaps_ShouldReturnFalse_WhenPlotsDoNotOverlap() {
        Plot plot1 = new Plot(2, 2, 4, 4);
        Plot plot2 = new Plot(6, 6, 3, 3);
        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    public void testEncompasses_ShouldReturnTrue_WhenPlotFullyEncompassesOtherPlot() {
        Plot plot1 = new Plot(2, 2, 8, 8);
        Plot plot2 = new Plot(4, 4, 3, 3);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testEncompasses_ShouldReturnFalse_WhenPlotDoesNotFullyEncompassOtherPlot() {
        Plot plot1 = new Plot(2, 2, 5, 5);
        Plot plot2 = new Plot(4, 4, 4, 4);
        assertFalse(plot1.encompasses(plot2));
    }

    @Test
    public void testEncompasses_ShouldReturnTrue_WhenPlotsAreEqual() {
        Plot plot1 = new Plot(2, 2, 5, 5);
        Plot plot2 = new Plot(2, 2, 5, 5);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testEncompasses_ShouldReturnTrue_WhenPlotIsEqualToItself() {
        Plot plot = new Plot(2, 2, 5, 5);
        assertTrue(plot.encompasses(plot));
    }

    @Test
    public void testToString_ShouldReturnStringRepresentationOfPlot() {
        Plot plot = new Plot(3, 4, 4, 3);
        assertEquals("3,4,4,3", plot.toString());
    }
        @Test
    public void testOverlaps_ShouldReturnFalse_WhenPlotsAreAdjacent() {
            Plot plot1 = new Plot(2, 2, 4, 4);
            Plot plot2 = new Plot(5, 5, 3, 3);
            assertFalse(plot1.overlaps(plot2));
        }
    }

