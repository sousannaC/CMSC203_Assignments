package implementation;

import org.junit.Test;
import static org.junit.Assert.*;

public class BevShopTestStudent {

    @Test
    public void testIsValidTime() {
        BevShop bevShop = new BevShop();
        assertTrue(bevShop.isValidTime(10)); // Assuming MIN_TIME is 0 and MAX_TIME is 23
        assertFalse(bevShop.isValidTime(-1));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        BevShop bevShop = new BevShop();
        assertEquals(5, bevShop.getMaxNumOfFruits()); // Assuming MAX_FRUIT is 5
    }

}
