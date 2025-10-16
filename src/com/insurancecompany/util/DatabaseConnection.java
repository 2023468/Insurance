
package com.insurancecompany.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Manages the database connection using credentials from a properties file.
 * This version is specifically for loading resources within a NetBeans project.
 */
public class DatabaseConnection {
    private static final Properties properties = new Properties();

    static {
        // This path correctly loads the file from within the application's classpath.
        // It looks for the file in the same package as the ConsoleUI class.
        try (InputStream input = DatabaseConnection.class.getResourceAsStream("/com/insurancecompany/app/db.properties")) {
            if (input == null) {
                System.err.println("CRITICAL ERROR: db.properties file not found in classpath!");
                System.err.println("Please ensure 'db.properties' is in the 'com.insurancecompany.app' package.");
                System.exit(1);
            }
            properties.load(input);
        } catch (IOException e) {
            // This will catch other I/O errors
            throw new RuntimeException("Could not load database properties", e);
        }
    }

    private static final String URL = properties.getProperty("db.url");
    private static final String USER = properties.getProperty("db.user");
    private static final String PASSWORD = properties.getProperty("db.password");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}