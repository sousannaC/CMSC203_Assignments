 package implementation;

 public class Smoothie extends Beverage {
	    private final double PROTEIN_COST = 1.5;
	    private final double FRUIT_COST = 0.5;
	    private int numOfFruits;
	    private boolean addProtein;

	    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
	        super(name, Type.SMOOTHIE, size);
	        this.numOfFruits = numOfFruits;
	        this.addProtein = addProtein;
	    }

	    @Override
	    public double calcPrice() {
	        double totalPrice = BASE_PRICE;
	        if (size != Size.SMALL) {
	            totalPrice += SIZE_UP_CHARGE;
	        }
	        if (addProtein) {
	            totalPrice += PROTEIN_COST;
	        }
	        totalPrice += numOfFruits * FRUIT_COST;
	        return totalPrice;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", Number of Fruits: " + numOfFruits + ", Add Protein: " + addProtein;
	    }

	}