package implementation;


import static org.junit.Assert.*;
import org.junit.Test;

public class AlcoholTestStudent {

    @Test
    public void testConstructor() {
        Alcohol alcohol = new Alcohol("Whiskey", Type.ALCOHOL, Size.LARGE, true);
        assertEquals("Whiskey", alcohol.getName());
        assertEquals(Type.ALCOHOL, alcohol.getType());
        assertEquals(Size.LARGE, alcohol.getSize());
        assertTrue(alcohol.isWeekendOffer());
    }

    @Test
    public void testCalcPriceWithoutWeekendOffer() {
        Alcohol alcohol = new Alcohol("Vodka", Type.ALCOHOL, Size.SMALL, false);
        assertEquals(2.0, alcohol.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithWeekendOffer() {
        Alcohol alcohol = new Alcohol("Rum", Type.ALCOHOL, Size.MEDIUM, true);
        assertEquals(3.6, alcohol.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Gin", Type.ALCOHOL, Size.LARGE, false);
        assertEquals("Beverage: Gin, Type: ALCOHOL, Size: LARGE", alcohol.toString());
    }

    @Test
    public void testEquals() {
        Alcohol alcohol1 = new Alcohol("Beer", Type.ALCOHOL, Size.MEDIUM, true);
        Alcohol alcohol2 = new Alcohol("Beer", Type.ALCOHOL, Size.MEDIUM, true);
        assertTrue(alcohol1.equals(alcohol2));
    }

}
