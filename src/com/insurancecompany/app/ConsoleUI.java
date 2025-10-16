
package com.insurancecompany.app;

import com.insurancecompany.dao.UserDAO;
import com.insurancecompany.model.Admin;
import com.insurancecompany.model.RegularUser;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Handles all console-based user interface logic (menus, input, output).
 * This separates the "view" from the main application logic.
 */
public class ConsoleUI {
    private final Scanner scanner;
    private final UserDAO userDAO;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.userDAO = new UserDAO();
    }

    public void start() {
        mainMenu();
        scanner.close(); // Close the scanner when the application exits.
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the User Management & Insurance System.");
            System.out.println("1) Admin Login");
            System.out.println("2) User Insurance Calculator");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    regularUserMenu();
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye.");
                    return; // Exit the loop and the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        // In a real app, this would check credentials against a database.
        if ("CCT".equals(username) && "Dublin".equals(password)) {
            System.out.println("Admin login successful.");
            Admin admin = new Admin(username, password, "Admin", "User");
            adminMenu(admin);
        } else {
            System.out.println("Incorrect admin credentials.");
        }
    }

    private void adminMenu(Admin admin) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1) View All Users");
            System.out.println("2) Add a New User");
            System.out.println("3) Edit My Profile");
            System.out.println("4) Logout");
            System.out.print("Enter an option: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    editAdminProfile(admin);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void viewAllUsers() {
        System.out.println("\n--- All Users in Database ---");
        List<String> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found in the database.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private void addNewUser() {
        System.out.println("\n--- Add New User ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (e.g., 'Admin', 'User'): ");
        String role = scanner.nextLine();

        if (userDAO.addUser(username, password, email, role)) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("Failed to add user.");
        }
    }
    
    private void editAdminProfile(Admin admin) {
        admin.displayProfile();
        System.out.print("Enter new first name (or press Enter to skip): ");
        String newFirst = scanner.nextLine();
        if (!newFirst.trim().isEmpty()) {
            admin.setFirstName(newFirst);
        }

        System.out.print("Enter new last name (or press Enter to skip): ");
        String newLast = scanner.nextLine();
        if (!newLast.trim().isEmpty()) {
            admin.setLastName(newLast);
        }
        System.out.println("Profile updated successfully.");
        admin.displayProfile();
    }

    private void regularUserMenu() {
        System.out.println("\n--- Car Insurance Calculator ---");
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        LocalDate dob = null;
        while (dob == null) {
            System.out.print("Enter your date of birth (YYYY-MM-DD): ");
            try {
                dob = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
        
        RegularUser user = new RegularUser("tempUser", "tempPass", firstName, lastName, dob);
        
        System.out.print("Enter your car model: ");
        String carModel = scanner.nextLine();
        
        System.out.print("Enter your car's year of manufacture: ");
        int carYear = getIntInput();
        
        user.setCarDetails(carModel, carYear);
        user.displayProfile();
    }
    
    /**
     * A robust helper method to get integer input from the user.
     * It handles cases where the user enters non-numeric text.
     * @return A valid integer.
     */
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}