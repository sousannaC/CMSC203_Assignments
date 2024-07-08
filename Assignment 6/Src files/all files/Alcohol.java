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

public class Alcohol extends Beverage {
    private boolean weekendOffer;
    private static final double WEEKEND_COST = 0.6;
    private static final double SIZE_UP_COST = 1.0;
    private Day currentDay;

    public Alcohol(String name, Type type, Size size, boolean weekendOffer) {
        super(name, type, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;

        switch (size) {
            case SMALL:
                // No additional cost for small size
                break;
            case MEDIUM:
                price += SIZE_UP_COST; // Additional cost for medium size
                break;
            case LARGE:
                price += SIZE_UP_COST * 2; // Additional cost for large size
                break;
        }

        // Check if it's a weekend and add the weekend cost if applicable
        if (isWeekend()) {
            price += WEEKEND_COST;
        }

        return price;
    }

    // Method to check if it's a weekend
    private boolean isWeekend() {
        return currentDay == Day.SATURDAY || currentDay == Day.SUNDAY;
    }
    
 // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for type
    public Type getType() {
        return type;
    }

    // Getter method for size
    public Size getSize() {
        return size;
    }
    // Getter and setter for weekendOffer
    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }

    // Getter and setter for currentDay
    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }
}
