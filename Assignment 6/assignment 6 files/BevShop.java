package implementation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BevShop implements BevShopInterface {
    public static final int MIN_TIME = 0;
    public static final int MAX_TIME = 24;
    public static final int MAX_FRUIT = 5;
    public static final int MIN_AGE_FOR_ALCOHOL = 21;
    public static final int MAX_ORDER_FOR_ALCOHOL = 3;
    public static final int MAX_ORDER_FOR_COFFEE = 3;
    public static final int MAX_ORDER_FOR_SMOOTHIE = 3;

    private int numAlcoholDrinksOrdered;
    private int numCoffeeDrinksOrdered;
    private int numSmoothieDrinksOrdered;
    private List<Order> orders;

    public BevShop() {
        this.numAlcoholDrinksOrdered = 0;
        this.numCoffeeDrinksOrdered = 0;
        this.numSmoothieDrinksOrdered = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numAlcoholDrinksOrdered < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numAlcoholDrinksOrdered;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }
    
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage beverage = new Coffee(bevName, size, extraShot, extraSyrup);
        addBeverageToCurrentOrder(beverage);
    }
 
    
   public void incrementNumCoffeeDrinksOrdered() {
        numCoffeeDrinksOrdered++;
   
		
	}

	@Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order order = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(order);
    }

    private void addBeverageToCurrentOrder(Beverage beverage) {
        Order currentOrder = getCurrentOrder();
        if (currentOrder != null) {
            currentOrder.addNewBeverage(beverage);
            updateDrinkCounters(beverage);
            updateOrderTotal(currentOrder);
        }
    }

    private void updateDrinkCounters(Beverage beverage) {
        if (beverage instanceof Alcohol) {
            numAlcoholDrinksOrdered++;
        } else if (beverage instanceof Coffee) {
            numCoffeeDrinksOrdered++;
        } else if (beverage instanceof Smoothie) {
            numSmoothieDrinksOrdered++;
        }
    }

    private void updateOrderTotal(Order order) {
        order.setTotalDrinks(order.getTotalDrinks() + 1);
        order.setTotalPrice(order.calcOrderTotal());
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            Beverage beverage = new Alcohol(bevName, Type.ALCOHOL, size, false);
            addBeverageToCurrentOrder(beverage);
        } else {
            System.out.println("You have reached the maximum limit for alcohol drinks in this order.");
        }
    }
    
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Beverage beverage = new Smoothie(bevName, Type.SMOOTHIE, size, numOfFruits, addProtein);
        addBeverageToCurrentOrder(beverage);
    }

    public void addAlcoholDrinkToOrder() {
        if (isEligibleForMore()) {
            processAlcoholOrder("Alcohol Drink", Size.SMALL);
        } else {
            System.out.println("You have reached the maximum limit for alcohol drinks in this order.");
        }
    }

    public void addSmoothieToOrder() {
        if (isEligibleForMoreSmoothies()) {
            processSmoothieOrder("Smoothie Drink", Size.SMALL, 3, false);
            System.out.println("Your current smoothie drink order is: " + getNumOfSmoothieDrinks());
        } else {
            System.out.println("You have reached the maximum limit for smoothie drinks in this order.");
        }
    }

    private boolean isEligibleForMoreSmoothies() {
        return numSmoothieDrinksOrdered < MAX_ORDER_FOR_SMOOTHIE;
    }

    public int getNumOfSmoothieDrinks() {
        return numSmoothieDrinksOrdered;
    }

    private boolean isEligibleForMoreCoffee() {
        return numCoffeeDrinksOrdered < MAX_ORDER_FOR_COFFEE;
    }

    public void addCoffeeDrinkToOrder() {
        if (isEligibleForMoreCoffee()) {
            processCoffeeOrder("Coffee Drink", Size.SMALL, false, false);
            System.out.println("Your current coffee drink order is: " + getNumOfCoffeeDrinks());
        } else {
            System.out.println("You have reached the maximum limit for coffee drinks in this order.");
        }
    }

    public int getNumOfCoffeeDrinks() {
        return numCoffeeDrinksOrdered;
    }

    @Override
    public double totalMonthlySale() {
        double totalSale = 0.0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i; 
            }
        }
        return -1; 
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public double totalOrderPrice(int orderNumber) {
        int orderIndex = findOrder(orderNumber);
        if (orderIndex != -1) {
            Order order = orders.get(orderIndex);
            return order.calcOrderTotal();
        }
        return 0.0; 
    }

    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null; 
    }
}

    