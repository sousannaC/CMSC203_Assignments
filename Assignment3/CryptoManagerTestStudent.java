package Crypto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

    @Test
    void isStringInBounds() {

        Assertions.assertTrue(CryptoManager.isStringInBounds("HELLO"));
        Assertions.assertTrue(CryptoManager.isStringInBounds("BYE"));
        Assertions.assertFalse(CryptoManager.isStringInBounds("hello"));
        Assertions.assertFalse(CryptoManager.isStringInBounds("bye"));
        Assertions.assertTrue(CryptoManager.isStringInBounds("123"));

    }

    @Test
    void caesarEncryption() {

        Assertions.assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("'bc", 4));
        Assertions.assertEquals("GHI", CryptoManager.caesarEncryption("DEF",3));
        Assertions.assertEquals("@ABC", CryptoManager.caesarEncryption("1234", 15));
        Assertions.assertEquals(";=>", CryptoManager.caesarEncryption("!#$", 90));
    }

    @Test
    void bellasoEncryption() {

        Assertions.assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("how", "yeah"));
        Assertions.assertEquals("PT#", CryptoManager.bellasoEncryption("HOW", "HELLO"));
        Assertions.assertEquals("!T#^", CryptoManager.bellasoEncryption("HOPE", "YES"));
    }

    @Test
    void caesarDecryption() {
        Assertions.assertEquals("DEF", CryptoManager.caesarDecryption("GHI", 3));
        Assertions.assertEquals("1234", CryptoManager.caesarDecryption("@ABC",15));
        Assertions.assertEquals("!#$", CryptoManager.caesarDecryption(";=>", 90));
    }

    @Test
    void bellasoDecryption() {

        Assertions.assertEquals("HOW", CryptoManager.bellasoDecryption("PT#", "HELLO"));
        Assertions.assertEquals("HOPE", CryptoManager.bellasoDecryption("!T#^", "YES"));
    }
}