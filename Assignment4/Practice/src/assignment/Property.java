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

public class Property {
	private String propertyName, city, owner; 
	private double rentAmount;
	private Plot plot;
	
	public Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x, y, width, depth);
	}

	public Property(Property otherProperty) {
		this.propertyName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.owner = otherProperty.getOwner();
		this.rentAmount = otherProperty.getRentalAmount();
		this.plot = otherProperty.getPlot();
	}
	
	public double getRentAmount() {
	    return rentAmount;
	}

	// Getters and setters
	public String getCity() {
		return city;
	}

	public String getOwner() {
		return owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public double getRentalAmount() {
		return rentAmount;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	// toString method
	@Override
	public String toString() {
		return propertyName + ", " + city + ", " + owner + ", " + rentAmount;
	}
}
