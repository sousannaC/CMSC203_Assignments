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
