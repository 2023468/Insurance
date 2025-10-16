/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Esvenn
 */
public class UserDAO {
    // Method to list all users
    public void listAllUsers() {
        String sql = "SELECT user_id, username, email, role FROM users";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            // Prints out user details
            System.out.println("=== Current Users ===");
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String role = rs.getString("role");
                
                System.out.println("ID: " + userId + ", Username: " + username +
                                   ", Email: " + email + ", Role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
      
        }
    }


    public void addUser(String username, String password, String email, String role) {
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Set parameters
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, role);
            
            // Execute query
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New user added successfully!");
            }
        } catch (SQLException e) {
            // Print error stack trace
            e.printStackTrace();
        }
    }
}
