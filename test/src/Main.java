
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Esvenn , santa
 */
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Using try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            mainMenu(scanner); // Start the main menu
        }
    }

    // Main Menu: Handles role selection (Admin or Regular User)
    private static void mainMenu(Scanner scanner) {
        int choice = 0;

        // Loop until the user selects a valid role
        while (choice != 1 && choice != 2) {
            System.out.println("Welcome to the User Management System.");
            System.out.println("Please select your role:");
            System.out.println("1) Admin");
            System.out.println("2) Regular User");
            System.out.print("Enter 1 or 2: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.\n");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Redirect to Admin or Regular User menu based on the choice
        if (choice == 1) {
            adminLogin(scanner);
        } else {
            regularUserMenu(scanner);
        }
    }

    // Admin Login: Allows admin to login with credentials
    private static void adminLogin(Scanner scanner) {
        int attempts = 0;
        boolean loggedIn = false;

        // Admin gets up to 3 login attempts
        while (attempts < 3 && !loggedIn) {
            System.out.println("Please enter Admin credentials.");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (username.equals("CCT") && password.equals("Dublin")) {
                loggedIn = true;
                Admin admin = new Admin("CCT", "Dublin", "AdminName", "AdminSurname");
                adminMenu(scanner, admin); // Go to Admin menu
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Incorrect admin credentials. Please try again.");
                }
            }
        }

        // If login failed after 3 attempts
        if (!loggedIn) {
            System.out.println("Sorry, you have used all 3 attempts.");
            System.out.println("Press 'R' to restart the system or any other key to exit.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("R")) {
                mainMenu(scanner); // Restart the program
            } else {
                System.out.println("Exiting the system. Goodbye.");
            }
        }
    }

    // Admin Menu: Displays options for admin
    private static void adminMenu(Scanner scanner, Admin admin) {
        int option = 0;

        // Loop until the user chooses to log out (option 4)
        while (option != 4) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1) View Current Users");
            System.out.println("2) Edit Outstanding Balances");
            System.out.println("3) Edit Profile");
            System.out.println("4) Logout");
            System.out.print("Enter an option (1-4): ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); 
                continue;
            }

            switch (option) {
                case 1:
                    viewCurrentUsers(); // Show list of users
                    break;
                case 2:
                    editOutstandingBalances(scanner); // Placeholder for editing balances
                    break;
                case 3:
                    editAdminProfile(scanner, admin); // Edit admin profile
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Placeholder: View current users
    private static void viewCurrentUsers() {
        UserDAO userDAO = new UserDAO();
        userDAO.listAllUsers();
    }

    // Placeholder: Edit outstanding balances
    private static void editOutstandingBalances(Scanner scanner) {
        System.out.println("Editing outstanding balances (Placeholder)...");
    }

    // Edit Admin profile details
    private static void editAdminProfile(Scanner scanner, Admin admin) {
        System.out.println("Current Admin Profile:");
        System.out.println("First Name: " + admin.getFirstName());
        System.out.println("Last Name: " + admin.getLastName());

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

        System.out.println("Profile updated. New details:");
        System.out.println("First Name: " + admin.getFirstName());
        System.out.println("Last Name: " + admin.getLastName());
    }

    // Regular User Menu: Handles insurance functionality
    private static void regularUserMenu(Scanner scanner) {
        System.out.println("Welcome, Regular User!");

        // Get user first and last name
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Get car details
        System.out.print("Enter your car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter your car year: ");
        int carYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a Regular User profile with car details
        Users regularUser = new Users("user", "password", firstName, lastName);
        regularUser.setCarDetails(carModel, carYear); // Set car details and calculate insurance price

        // Display the user's profile and insurance price
        regularUser.displayProfile();
    }
}

