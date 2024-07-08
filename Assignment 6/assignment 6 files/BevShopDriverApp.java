package implementation;
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        
        String startNewOrder = "yes"; // Initialize to start the loop

        while (startNewOrder.equalsIgnoreCase("yes")) {
            System.out.println("Would you like to start a new order? (yes/no):");
            startNewOrder = scanner.nextLine(); // Prompt inside the loop

            if (!startNewOrder.equalsIgnoreCase("yes")) {
                break; // Exit the loop if the user doesn't want to start a new order
            }

            // Prompt user for order details
            System.out.println("Would you please enter your name:");
            String name = scanner.nextLine();

            int age;
            while (true) {
                System.out.println("Would you please enter your age:");
                String ageInput = scanner.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid age.");
                }
            }

            // Start a new order
            bevShop.startNewOrder(0, Day.MONDAY, name, age);

            System.out.println("Your age is " + age + " and you are " + (age >= 21 ? "eligible" : "not eligible") + " to order alcohol.");

            if (age >= 21) {
                System.out.println("Would you like to add an alcohol drink? (yes/no):");
                String addAlcoholDrink = scanner.nextLine();

                while (addAlcoholDrink.equalsIgnoreCase("yes")) {
                    bevShop.addAlcoholDrinkToOrder();

                    // Display current order information
                    Order currentOrder = bevShop.getCurrentOrder();
                    System.out.println("The current order of drinks is: " + currentOrder.getTotalDrinks());
                    System.out.println("The Total price on the Order is: " + currentOrder.calcOrderTotal());
                    System.out.println("Your current alcohol drink order is: " + bevShop.getNumOfAlcoholDrink());

                    System.out.println("Would you like to add another alcohol drink? (yes/no):");
                    addAlcoholDrink = scanner.nextLine();
                }
            } else {
                // Offer coffee or smoothie
                System.out.println("Would you like to order a coffee or a smoothie?");
                String beverageType = scanner.nextLine();

                System.out.println("Enter the name of the beverage:");
                String bevName = scanner.nextLine();
                System.out.println("Enter the size of the beverage (small, medium, large):");
                Size size;
                while (true) {
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("small") || input.equals("medium") || input.equals("large")) {
                        size = Size.valueOf(input.toUpperCase());
                        break;
                    } else {
                        System.out.println("Invalid size. Please enter small, medium, or large.");
                    }
                }
                if (beverageType.equalsIgnoreCase("coffee")) {
                    System.out.println("Would you like an extra shot? (yes/no):");
                    boolean extraShot = scanner.nextLine().equalsIgnoreCase("yes");
                    System.out.println("Would you like extra syrup? (yes/no):");
                    boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("yes");

                    bevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                } else if (beverageType.equalsIgnoreCase("smoothie")) {
                    System.out.println("Enter the number of fruits:");
                    int numOfFruits = Integer.parseInt(scanner.nextLine());
                    System.out.println("Would you like to add protein? (yes/no):");
                    boolean addProtein = scanner.nextLine().equalsIgnoreCase("yes");

                    bevShop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                } else {
                    System.out.println("Invalid choice. Please select coffee or smoothie.");
                }
            }
            
         // Display total items and total price on the order
            Order currentOrder = bevShop.getCurrentOrder();
            if (currentOrder != null) {
                System.out.println("Total items on your order: " + currentOrder.getTotalDrinks());
                System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());
            } else {
                System.out.println("No order found.");
            }
        }

        System.out.println("Programmer name: Sousanna Chugunova");


        scanner.close();
    }
}

