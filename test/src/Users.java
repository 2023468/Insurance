/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santa
 */
public class Users {
    // Private fields to encapsulate user data
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String carModel;  // For Regular Users: car model
    private int carYear;      // For Regular Users: car year
    private int insurancePrice; // Calculated insurance price

    // Constructor to initialize basic user details
    public Users(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Getter and Setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Set car details for Regular Users
    public void setCarDetails(String carModel, int carYear) {
        this.carModel = carModel;
        this.carYear = carYear;
        calculateInsurancePrice(); // Automatically calculate insurance price
    }

    // Private method to calculate random insurance price between $1,000 and $3,000
    private void calculateInsurancePrice() {
        this.insurancePrice = 1000 + (int) (Math.random() * 2001);
    }

    // Display user's profile and insurance details
    public void displayProfile() {
        System.out.println("\n=== User Profile ===");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Car Year: " + carYear);
        System.out.println("Estimated Insurance Price: $" + insurancePrice);
    }
}
