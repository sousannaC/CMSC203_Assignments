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


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private int totalDrinks;
    private Customer customer;
    private List<Beverage> beverages;
    private double totalPrice; // Total price of the order
    private int totalAlcoholDrinks; // Counter for total number of alcohol drinks
    
    // Constructor with random order number generation
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber(); // Generate random order number
        this.orderTime = orderTime; // Set order time
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
        this.totalPrice = 0.0; // Initialize total price
        this.totalAlcoholDrinks = 0; // Initialize total alcohol drinks counter
    }

    // Method to generate a random order number
    private int generateOrderNumber() {
        Random random = new Random();
        return random.nextInt(80001) + 10000;
    }

    // Method to add a coffee beverage with extra parameters
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage beverage = new Coffee(bevName, size, extraShot, extraSyrup);
        addNewBeverage(beverage);
    }

    // Overloaded method to add a coffee beverage without extra parameters
    public void addNewBeverage(String bevName, Size size) {
        Beverage beverage = new Coffee(bevName, size, false, false); // Create a coffee beverage without extras
        addNewBeverage(beverage);
    }

    // Method to add a smoothie beverage
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Beverage beverage = new Smoothie(bevName, null, size, numOfFruits, addProtein);
        addNewBeverage(beverage);
    }

    // Method to add an alcohol beverage
    public void addAlcoholBeverage(String bevName, Size size) {
        Beverage beverage = new Alcohol(bevName, null, size, false);
        addNewBeverage(beverage);
        if (beverage.getType() == Type.ALCOHOL) {
            totalAlcoholDrinks++;
        }
    }

    // Helper method to add a beverage to the order and update total price
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
        totalPrice += beverage.calcPrice(); // Update total price
    }

    // Calculate the total order price
    public double calcOrderTotal() {
        return totalPrice;
    }

    // Method to get the total number of alcohol drinks in the order
    public int getTotalAlcoholDrinks() {
        return totalAlcoholDrinks;
    }
 // Overridden toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage).append("\n");
        }
        sb.append("The current order of drinks is: ").append(totalDrinks).append("\n");
        sb.append("The Total price on the Order is: ").append(calcOrderTotal()).append("\n");
        sb.append("Your current alcohol drink order is: ").append(getTotalAlcoholDrinks()).append("\n");
        return sb.toString();
    }

    // Getters and setters
    
    public int getTotalDrinks() {
        return totalDrinks;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
   
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy of the customer
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

   

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderNumber, o.orderNumber);
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public void setTotalDrinks(int totalDrinks) {
        this.totalDrinks = totalDrinks;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
