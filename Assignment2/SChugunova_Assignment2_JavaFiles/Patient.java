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
public class Patient {
    // Fields
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Parametrized constructor for all attributes
    public Patient(String firstName, String middleName, String lastName, String streetAddress, String city, String state, String zipCode, String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Accessors for each attribute
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    // Mutators for each attribute
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build address
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    // Method to build emergency contact information
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    // Override toString method to display all information of a patient
    @Override
    public String toString() {
        return "Patient info:\n" 
    + "\s\sFull Name: " + buildFullName() + "\n"
                + "\s\sAddress: " + buildAddress() + "\n"
                + "\s\sPhone Number: " + phoneNumber + "\n"
                + "\s\sEmergency Contact: " + buildEmergencyContact();
    }
    public static void main(String[] args) {
        // Create a Patient object
        Patient patient = new Patient("John", "Doe", "Smith", "123 Main St", "Springfield", "IL", "12345", "555-123-4567", "Jane Doe", "555-987-6543");

        // Display patient information
        System.out.println(patient);
    }
}