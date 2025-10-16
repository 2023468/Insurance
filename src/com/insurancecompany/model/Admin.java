
package com.insurancecompany.model;

/**
 * Represents an Admin user in the system.
 * This class extends the base User class, inheriting its common properties
 * like username, password, first name, and last name.
 */
public class Admin extends User {
    
    /**
     * Constructor for creating a new Admin object.
     * It passes the user details up to the parent User class constructor.
     *
     * @param username The admin's username.
     * @param password The admin's password.
     * @param firstName The admin's first name.
     * @param lastName The admin's last name.
     */
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

    /**
     * Overrides the abstract displayProfile method from the User class.
     * Provides a specific implementation for how an Admin's profile should be displayed.
     */
    @Override
    public void displayProfile() {
        System.out.println("\n=== Admin Profile ===");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Role: Administrator");
    }
}