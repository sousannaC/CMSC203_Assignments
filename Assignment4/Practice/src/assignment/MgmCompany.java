/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Plot Class: Implement methods for x, y, width, and depth fields in the Plot class.
PlotTestStudent: Write JUnit test methods for public Plot class methods.
Property Class: Define fields for property name, city, rent, owner, and plot in Property class.
PropertyTestStudent: Develop JUnit tests for Property class public methods.
ManagementCompany Class: Create fields for company name, tax ID, fee percentage, properties, and plot in ManagementCompany class.
ManagementCompanyTestStudent: Construct JUnit tests for ManagementCompany class methods.
 * Due: 04/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sousanna Chugunova
*/

package assignment; 

public class MgmCompany {
    private String name;
    private String taxId;
    private double managementFeePercentage;
    private final int MAX_PROPERTY = 5;
    private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;
    private Property[] properties; // Array to hold properties
    private int numberOfProperties;
    private Plot plot;

    public MgmCompany(String name, String taxId, double managementFeePercentage) {
        this.name = name;
        this.taxId = taxId;
        this.managementFeePercentage = managementFeePercentage;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public Plot getPlot() {
        return plot;
    }

    public String getName() {
        return name;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null; // No properties
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2; // Property is null
        }
        if (isPropertiesFull()) {
            return -1; // Array is full
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; // Plot is not encompassed by management company plot
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (property.getPlot().overlaps(properties[i].getPlot())) {
                return -4; // Plot overlaps with existing property
            }
        }
        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; // Index where property was added
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return managementFeePercentage >= 0 && managementFeePercentage <= 100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i]).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        sb.append(" total management Fee: ").append(getTotalRent() * managementFeePercentage / 100);
        return sb.toString();
    }

    public void setManagementFeePercentage(double managementFeePercentage) {
        this.managementFeePercentage = managementFeePercentage;
    }

    public Property[] getPropertiesAboveRent(int rent) {
        int count = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > rent) {
                count++;
            }
        }
        Property[] aboveRentProperties = new Property[count];
        int index = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > rent) {
                aboveRentProperties[index++] = properties[i];
            }
        }
        return aboveRentProperties;
    }

    public int addProperty(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        // Create a new Property object using the appropriate constructor
        Property property = new Property(propertyName, city, rentalAmount, owner, x, y, width, depth);
        
        // Add the property to the properties array
        int result = addProperty(property);
        return result;
    }

    public boolean removeProperty(int index) {
        if (index < 0 || index >= numberOfProperties) {
            return false; // Index out of bounds
        }
        for (int i = index; i < numberOfProperties - 1; i++) {
            properties[i] = properties[i + 1];
        }
        properties[numberOfProperties - 1] = null;
        numberOfProperties--;
        return true;
        
    
    }
}
