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
import java.util.Random;


public class PatientDriverApp {
    public static void main(String[] args) {
        // Create a patient object with sample data
        Patient patient = new Patient("Marc", "pat", "Jacobs", "1324 bridge rd", "Vienna", "VA", "20874", "123-456-7891", "Bernadette Allowe", "321-123-4321");

        // Generate random procedure details
        Procedure procedure1 = generateRandomProcedure();
        Procedure procedure2 = generateRandomProcedure();
        Procedure procedure3 = generateRandomProcedure();

        // Display patient information4
        displayPatient(patient);

        // Display information for each procedure
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("\n\nTotal Charges: $" + String.format("%.2f", totalCharges));
        System.out.println("\n\nThe program was developed by a Student: Sousanna Chugunova 02/21/2024");
    }

    // Method to display patient information
    public static void displayPatient(Patient patient) {
        System.out.println(patient);
    }

    // Method to display procedure information
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }

    // Method to calculate total charges
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        double totalCharges = procedure1.getProcedureCharge() + procedure2.getProcedureCharge() + procedure3.getProcedureCharge();
        return totalCharges;
    }

    // Method to generate random procedure details
    public static Procedure generateRandomProcedure() {
        Random rand = new Random();
        String[] procedureNames = {"Dental Cleaning", "X-Ray", "Blood Test", "Check up"};
        String[] practitionerNames = {"Dr. Johnson", "Dr. Smith", "Dr. Brown"};
        double[] charges = {-10.00 , 50.00, 100.00, 150.00, 200.00, 250.00, 300.00, 350.00, 400.00};
        String procedureName = procedureNames[rand.nextInt(procedureNames.length)];
        String practitionerName = practitionerNames[rand.nextInt(practitionerNames.length)];
        double charge = charges[rand.nextInt(charges.length)];
        // Generate a random date (
        String procedureDate = "2024-02-21";
        return new Procedure(procedureName, procedureDate, practitionerName, charge);
    }
}

