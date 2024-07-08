/*
 * Class: CMSC203 
 * Instructor: Prof. Grinberg
 * Description: Building a color guessing game
 * Due: 02/05/2024
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Sousanna Chugunova
*/

import java.util.Scanner;
public class ESPGame {

		    private static final String RED = "Red";
		    private static final String GREEN = "Green";
		    private static final String BLUE = "Blue";
		    private static final String ORANGE = "Orange";
		    private static final String YELLOW = "Yellow";
		    private static final String PURPLE = "Purple";
		    private static final String PINK = "Pink";

		    private static final int NUM_TRIALS = 11;
		    
		    public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in); 
				
		        System.out.print("Enter your name: ");
		        String name = scanner.nextLine();

		        System.out.print("Enter your MC M#: ");
		        String mcNumber = scanner.nextLine();

		        System.out.print("Describe yourself: ");
		        String description = scanner.nextLine();

		        System.out.print("Enter Due Date (MM/DD/YY): ");
		        String dueDate = scanner.nextLine();

		        int correctGuesses = 0;

		        for (int i = 0; i < NUM_TRIALS; i++) {
		            System.out.println("\nI am thinking of a color.");
		            System.out.println("Is it Red, Green, Blue, Orange, Yellow, Purple, or Pink?");

		            int randomNumber = (int) (Math.random() * 7);
		            String selectedColor = getColorByNumber(randomNumber);

		            System.out.print("Enter your guess: ");
		            String userGuess = scanner.nextLine();

		            if (isValidColor(userGuess)) {
		                if (selectedColor.equalsIgnoreCase(userGuess)) {
		                    System.out.println("Correct!");
		                    correctGuesses++;
		                } else {
		                    System.out.println("Incorrect. I was thinking of: " + selectedColor);
		                }
		            } else {
		                System.out.println("Invalid input. Please enter a valid color.");
		                i--; // Decrement the loop counter to repeat the current trial
		            }
		        }

		        System.out.println("\nGame over!");
		        System.out.println("\nYou guessed " + correctGuesses + " out of " + NUM_TRIALS + " correctly.");
		        System.out.println("Name: " + name);
		        System.out.println("MC M#: " + mcNumber);
		        System.out.println("User Description: " + description);
		        System.out.println("Due Date: " + dueDate);

		        scanner.close();
		    }

		    private static String getColorByNumber(int number) {
		        switch (number) {
		            case 0:
		                return RED;
		            case 1:
		                return GREEN;
		            case 2:
		                return BLUE;
		            case 3:
		                return ORANGE;
		            case 4:
		                return YELLOW;
		            case 5:
		                return PURPLE;
		            case 6:
		                return PINK;
		            default:
		                return "";
		        }
		    }

		    private static boolean isValidColor(String color) {
		        return color.equalsIgnoreCase(RED) || color.equalsIgnoreCase(GREEN) ||
		               color.equalsIgnoreCase(BLUE) || color.equalsIgnoreCase(ORANGE) ||
		               color.equalsIgnoreCase(YELLOW) || color.equalsIgnoreCase(PURPLE) ||
		               color.equalsIgnoreCase(PINK);
		    }
	
	}

