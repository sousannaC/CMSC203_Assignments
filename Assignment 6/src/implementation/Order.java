package implementation;
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private String orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(String orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    private int generateOrderNumber() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000; // Generate a random number within the range 10000-90000
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        beverages.add(coffee);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        Alcohol alcohol = new Alcohol(bevName, size);
        beverages.add(alcohol);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverages.add(smoothie);
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
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            sb.append("- ").append(beverage).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

    // Getters and setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }
}
