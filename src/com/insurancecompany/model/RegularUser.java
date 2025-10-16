
package com.insurancecompany.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a regular user with car insurance details.
 */
public class RegularUser extends User {
    private String carModel;
    private int carYear;
    private LocalDate dateOfBirth;
    private double insurancePrice;

    public RegularUser(String username, String password, String firstName, String lastName, LocalDate dateOfBirth) {
        super(username, password, firstName, lastName);
        this.dateOfBirth = dateOfBirth;
    }

    public void setCarDetails(String carModel, int carYear) {
        this.carModel = carModel;
        this.carYear = carYear;
        // The insurance price is calculated when car details are set.
        this.insurancePrice = calculateInsurancePrice();
    }

    /**
     * A more realistic insurance calculation based on car age and driver's age.
     * @return The calculated insurance price.
     */
    private double calculateInsurancePrice() {
        // Base price
        double price = 1000.0;
        
        // Increase price for older cars
        int carAge = LocalDate.now().getYear() - this.carYear;
        if (carAge > 10) {
            price += 500;
        } else if (carAge > 5) {
            price += 250;
        }

        // Increase price for younger drivers
        int driverAge = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        if (driverAge < 25) {
            price += 600;
        } else if (driverAge < 30) {
            price += 300;
        }
        
        // Add a small random factor for variability
        price += (Math.random() * 200 - 100); // +/- $100
        
        return Math.round(price * 100.0) / 100.0; // Round to 2 decimal places
    }

    @Override
    public void displayProfile() {
        System.out.println("\n=== User Profile ===");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Date of Birth: " + dateOfBirth);
        if (carModel != null) {
            System.out.println("Car Model: " + carModel);
            System.out.println("Car Year: " + carYear);
            System.out.printf("Estimated Insurance Price: $%.2f%n", insurancePrice);
        }
    }
}