/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santa
 */
import java.util.Scanner;
import java.util.Random;

public class UserProfile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Insurance Calculator!");
        
        // Ask for user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        // Ask for date of birth
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        
        // Ask for car details
        System.out.print("Enter your car model: ");
        String carModel = scanner.nextLine();
        
        System.out.print("Enter your car's year of manufacture: ");
        int carYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        // Generate random insurance price
        Random random = new Random();
        int insurancePrice = 1000 + random.nextInt(2001); // Random number between 1000 and 3000

        // Display profile and insurance price
        System.out.println("\n=== User Profile ===");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Car Model: " + carModel);
        System.out.println("Car Year: " + carYear);
        System.out.println("Estimated Insurance Price: $" + insurancePrice);
        
        scanner.close();
    }
}
