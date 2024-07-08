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

public class Plot {
    // Attributes
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot() {
		// TODO Auto-generated constructor stub
	}

	// Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    // Method to check if the current plot overlaps with another plot
    public boolean overlaps(Plot other) {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int otherX2 = other.x + other.width;
        int otherY2 = other.y + other.depth;

        return (this.x < otherX2 && thisX2 > other.x && this.y < otherY2 && thisY2 > other.y);
    }

    // Method to check if the current plot encompasses another plot
    public boolean encompasses(Plot other) {
        return (other.x >= this.x && other.y >= this.y && other.x + other.width <= this.x + this.width
                && other.y + other.depth <= this.y + this.depth);
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
