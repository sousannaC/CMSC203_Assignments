/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Make an order with three different types of beverage choice options
 * Due: 04/29/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sousanna Chugunova
*/



package implementation;

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private static final double EXTRA_SHOT_COST = 0.5;
    private static final double EXTRA_SYRUP_COST = 0.75;
    private static final double SIZE_UP_COST = 1.0;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }
    
    @Override
    public double calcPrice() {
        double price = BASE_PRICE; // Start with the base price

        // Add additional cost based on the size
        switch (size) {
            case MEDIUM:
                price += SIZE_UP_COST; // Additional cost for medium size
                break;
            case LARGE:
                price += SIZE_UP_COST * 2; // Additional cost for large size
                break;
            default:
                break; // No additional cost for small size
        }

        // Add additional cost for extra shot, if added
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }

        // Add additional cost for extra syrup, if added
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }

        return price; // Return the total price
    }

  
    public Type getType() {
        return Type.COFFEE;
    }
}