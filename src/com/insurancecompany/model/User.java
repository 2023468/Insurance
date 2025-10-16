
package com.insurancecompany.model;

/**
 * Base abstract class for all user types.
 * Defines common properties like username, name, etc.
 */
public abstract class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // --- Getters and Setters ---
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * An abstract method that forces subclasses (like Admin and RegularUser)
     * to provide their own way of displaying a profile.
     */
    public abstract void displayProfile();
}