
package com.insurancecompany.dao;

import com.insurancecompany.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for handling User-related database operations.
 */
public class UserDAO {

    /**
     * Retrieves a list of all usernames and roles from the database.
     * @return A list of strings, each containing user details.
     */
    public List<String> getAllUsers() {
        List<String> userList = new ArrayList<>();
        String sql = "SELECT username, email, role FROM users";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String role = rs.getString("role");
                userList.add("Username: " + username + ", Email: " + email + ", Role: " + role);
            }
        } catch (SQLException e) {
            System.err.println("Database Error: Could not retrieve users.");
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * Adds a new user to the database.
     * @return true if the user was added successfully, false otherwise.
     */
    public boolean addUser(String username, String password, String email, String role) {
        // Note: In a real app, passwords should be securely hashed before storing!
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        boolean success = false;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password); 
            stmt.setString(3, email);
            stmt.setString(4, role);
            
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println("Database Error: Could not add the new user.");
            e.printStackTrace();
        }
        return success;
    }
}