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
