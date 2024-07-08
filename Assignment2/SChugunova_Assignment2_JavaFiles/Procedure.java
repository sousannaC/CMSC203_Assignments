/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg 
 * Assignment 2
 * Description: 
*Patient:User inputs name, address, phone number and emergency contact information. 
*Procedure:Describe the name, date, practitioner, and cost of procedure.
*PatientDriverApp: Using the information inputed by user, display information in a more user friendly way. 
 * Due: 02/26/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Sousanna Chugunova
*/

package patient;

public class Procedure {
    // Fields
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharge;

    // No-arg constructor
    public Procedure() {
        // Initialize fields with default values
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.procedureCharge = 0.0;
    }

    // Parametrized constructor for name and date
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        // Defaults for other fields
        this.practitionerName = "";
        this.procedureCharge = 0.0;
    }

    // Parametrized constructor for all attributes
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharge) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharge = procedureCharge;
    }

    // Accessors and Mutators
    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public double getProcedureCharge() {
        return procedureCharge;
    }

    public void setProcedureCharge(double procedureCharge) {
        this.procedureCharge = procedureCharge;
    }

    // toString method
    public String toString() {
        // Format the procedure charge to two decimal places
        String formattedCharge = String.format("%.2f", procedureCharge);
        
        return "\n\tProcedure:" +procedureName + "\n"
                + "\tProcedure Date: " + procedureDate + "\n"
                + "\tPractitioner: " + practitionerName + "\n"
                + "\tCharge: " + formattedCharge;
    }

    public static void main(String[] args) {
        // Create a procedure object
        Procedure procedure = new Procedure("Dental Cleaning", "2024-02-21", "Dr. Smith", 150.00);

        // Display procedure information
        System.out.println(procedure);

        // Display the student information
        System.out.println("\n\nThe program was developed by a Student: <Sousanna Chugunova> <02/21/2024>");
    }
}
