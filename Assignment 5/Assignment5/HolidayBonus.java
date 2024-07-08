/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: TwoDimRaggedArrayUtility class deals with working with two-dimensional ragged arrays of doubles. 
 * HolidayBonus class deals with highest sales in a category, another for the store with the lowest sales in a 
 * category, and the third for all other stores.
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Sousanna Chugunova 
*/


package bonus;

public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGHEST_SALES_BONUS = 5000.0;
    private static final double LOWEST_SALES_BONUS = 1000.0;
    private static final double OTHER_STORES_BONUS = 2000.0;

    /**
     * Calculates the holiday bonuses for each store based on the sales data.
     * 
     * @param data A ragged array of doubles representing the sales for each store in each category.
     * @return An array of doubles containing the holiday bonuses for each store.
     * @throws IllegalArgumentException if the sales data is empty or null.
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        // Check if the sales data is empty or null
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Sales data is empty or null.");
        }

        // Array to store bonuses for each store
        double[] bonuses = new double[data.length];

        // Iterate over each category
        for (int i = 0; i < data[0].length; i++) {
            // Variables to track highest and lowest sales for the current category
            double highestSales = Double.MIN_VALUE;
            double lowestSales = Double.MAX_VALUE;

            // Find highest and lowest sales for the current category
            for (double[] storeSales : data) {
                if (storeSales.length > i) {
                    double sales = storeSales[i];
                    if (sales > highestSales) {
                        highestSales = sales;
                    }
                    if (sales < lowestSales) {
                        lowestSales = sales;
                    }
                }
            }

            // Calculate bonuses for each store in the current category
            for (int j = 0; j < data.length; j++) {
                if (data[j].length > i) {
                    double sales = data[j][i];
                    double bonus = 0.0;
                    if (sales == highestSales) {
                        bonus = HIGHEST_SALES_BONUS;
                    } else if (sales == lowestSales) {
                        bonus = LOWEST_SALES_BONUS;
                    } else {
                        bonus = OTHER_STORES_BONUS;
                    }
                    // Add the bonus to the corresponding store
                    bonuses[j] += bonus;
                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses for all stores.
     * 
     * @param data A ragged array of doubles representing the sales for each store in each category.
     * @return The total holiday bonuses for all stores.
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0.0;
        double[] bonuses = calculateHolidayBonus(data);
        // Add up all the individual bonuses to get the total bonus
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }

    /**
     * Getter method to return the bonus amount for the store with the highest sales in a category.
     * 
     * @return The bonus amount for the store with the highest sales.
     */
    public static double getHighestSalesBonus() {
        return HIGHEST_SALES_BONUS;
    }

    /**
     * Getter method to return the bonus amount for the store with the lowest sales in a category.
     * 
     * @return The bonus amount for the store with the lowest sales.
     */
    public static double getLowestSalesBonus() {
        return LOWEST_SALES_BONUS;
    }

    /**
     * Getter method to return the bonus amount for all other stores.
     * 
     * @return The bonus amount for all other stores.
     */
    public static double getOtherStoresBonus() {
        return OTHER_STORES_BONUS;
    }
}
