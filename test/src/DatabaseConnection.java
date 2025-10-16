/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Esvenn
 */
public class DatabaseConnection {
  
      // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/databaseCA"; 
    private static final String USER = "ooc2023";
    private static final String PASSWORD = "ooc2023";
    
    public static Connection getConnection() throws SQLException {
        
         // Return a connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


