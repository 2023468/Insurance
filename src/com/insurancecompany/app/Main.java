
package com.insurancecompany.app;

/**
 * The main entry point for the application.
 * Its only job is to create the ConsoleUI and start it.
 * This keeps the main method clean and simple.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleApp = new ConsoleUI();
        consoleApp.start();
    }
}