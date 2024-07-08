/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: CryptoManager class holds all the methods to execute the code. GUI driver class helps display the code in a more user friendly manner. 
 * Due: 03/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: __Sousanna Chugunova________
*/
package Crypto;


public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
		boolean inBounds = true; // set inbounds to true

		for (int i = 0; i < plainText.length(); i++) { // iterate the string

			char character = plainText.charAt(i); //store string

			if (character < LOWER_RANGE || character > UPPER_RANGE) {// if not between allowable range set inBounds to false
				inBounds = false;
				break;
			}
		}

		return inBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {

		//plainText.toUpperCase();

		String encryptedString = "";
		char character;

		if (isStringInBounds(plainText)) {

			for (int i = 0; i < plainText.length(); i++) {

				character = plainText.charAt(i);


				while (key > UPPER_RANGE) { // if the key is greater than upper range, wrap it
					key = (key - RANGE);
				}
				character = (char) (character + key); // get the corresponding char of the integer of character and key

				if (character > UPPER_RANGE) {// if the character is greater than the upper range then wrap the character
					character = (char) ((character - UPPER_RANGE + LOWER_RANGE) - 1);
				}

				encryptedString += character; // add the encrypted character to encrypted string

			}

		} else
			encryptedString = "The selected string is not in bounds, Try again.";

		return encryptedString;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {

		String encrypted = "";
		char characterOriginal;
		char characterKeyWord;
		char characterEncrypted;
		int key;

		if (isStringInBounds(plainText) && isStringInBounds(bellasoStr)) {

			if (bellasoStr.length() < plainText.length()) //if key word length is less than original text
			{
				int difference = plainText.length() - bellasoStr.length(); // length difference

				for (int i = 0; i < difference; i++) // only add until the length of keyword and original is equal
					bellasoStr += bellasoStr.charAt(0 + i);

			}


			for (int i = 0; i < plainText.length(); i++) { // iterate through the original text string

				characterOriginal = plainText.charAt(i); // assign the current character of the original text
				characterKeyWord = bellasoStr.charAt(i); // assign the current character of  the keyword

				int charOrigin = (int) characterOriginal; //ascii integer of CharOrigin
				int charKey = (int) (characterKeyWord); //ascii integer of charKeyWord

				key = charOrigin + charKey; // add both integer of chars[charOrigin and charKey]

				while (key > UPPER_RANGE) { // if key is in range and greater than upper limit
					key -= RANGE;
				}

				characterEncrypted = (char) (key); // convert the corresponding char of the integer key

				encrypted += characterEncrypted; // add the encrypted letter


			}
		}
		else
			encrypted = "The selected string is not in bounds, Try again.";

		return encrypted;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {

		String decrypted = "";

		char character;


		for (int i = 0; i < encryptedText.length(); i++) {

			character = encryptedText.charAt(i);


			while (key > RANGE-1) {
				key = (key - RANGE);
			}
			character = (char) (character - key);

			if (character < LOWER_RANGE) { // if the character is lower than the LOWER_RANGE, wrap the character
				character = (char) ((character + UPPER_RANGE - LOWER_RANGE) + 1);
			}

			decrypted += character;

		}

		return decrypted;


	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String original = "";
		char enChar;
		int oChar;
		for (int i = 0; i < encryptedText.length(); i++) {
			enChar = encryptedText.charAt(i);
			oChar = (int)(enChar) - (int)(bellasoStr.charAt(i % bellasoStr.length()));
			while (oChar < LOWER_RANGE) {
				oChar = oChar + RANGE;
			}
			original += (char)(oChar);
		}
		return original;
	}
	
	
}
