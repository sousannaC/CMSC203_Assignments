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
public abstract class Beverage {
    protected String name;
    protected Type type;
    protected Size size;
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_UP_COST = 1.0;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage: " + name + ", Size: " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }
    
    public Type getType() {
        return type;
    }
}


