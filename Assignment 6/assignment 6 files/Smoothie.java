package implementation;

public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private static final double FRUIT_PRICE = 0.5;
    private static final double PROTEIN_PRICE = 1.0;
    private static final double SIZE_UP_COST = 1.0;

    public Smoothie(String name, Type type, Size size, int numOfFruits, boolean addProtein) {
    	
        super(name, type, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
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

        // Add additional cost for protein, if added
        if (addProtein) {
            price += PROTEIN_PRICE;
        }

        // Add additional cost for fruits
        price += numOfFruits * FRUIT_PRICE;

        return price; // Return the total price
    }

    @Override
    public String toString() {
        double price = calcPrice(); // Calculate the price
        return "Smoothie: " + name + ", Size: " + size + ", Number of Fruits: " + numOfFruits + ", Protein Added: " + addProtein + ", Price: $" + price;
    }

    public Type getType() {
        return Type.SMOOTHIE;
    }
}
