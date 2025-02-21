package jvafx_projet;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBase {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";  // Change to your database name
    private static final String USER = "root";  // Default XAMPP MySQL username
    private static final String PASSWORD = "";  // Default XAMPP MySQL password is empty

    // Insert an item into the database
    public static void insertItem(String name, double price,int quantity) {
        String query = "INSERT INTO item (name, quantity, price) VALUES (?, ?, ?)"; // Ensure table name is 'item'
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  // Establish connection
            ps = conn.prepareStatement(query);  // Prepare the SQL query
            ps.setString(1, name);  // Set the item name
            ps.setInt(2, quantity);  // Set the item price
            ps.setDouble(3, price);  // Set the item quantity
            ps.executeUpdate();  // Execute the query
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Get all items from the database
    public static ObservableList<Item> getItems() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        String query = "SELECT name,quantity,price FROM item";  // Query to select all items from the 'item' table
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  // Establish connection
            stmt = conn.createStatement(); // Create a statement object
            rs = stmt.executeQuery(query);  // Execute the query

            // Loop through the result set and add each item to the list
            while (rs.next()) {
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                items.add(new Item(name, price ,quantity));  // Create Item object and add it to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                   stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }
    public static double  gettotal() {
        
        String query = "SELECT SUM(total) AS average_total FROM item";  // Query to select all items from the 'item' table
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null; 
        double total = 0.0;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  // Establish connection
            stmt =conn.createStatement();  // Create a statement object
            rs = stmt.executeQuery(query);  // Execute the query
           

            // Loop through the result set and add each item to the list
            while (rs.next()) {
               
                total  = rs.getDouble("average_total");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total;
    }
    public static void clear() {
    	String query = "DELETE FROM item";  // Query to select all items from the 'item' table
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  // Establish connection
            stmt =conn.createStatement();  // Create a statement object
            stmt.executeUpdate(query);  // Execute the query
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();  
                }
                if (conn != null) {
                    conn.close();  
                }
            } catch (SQLException e) {
                e.printStackTrace();  
            }
        }
       
    }
    //update quantity in database
    public static void updateQuantity(String name, int newQuantity) {
        String query = "UPDATE item SET quantity = ? WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
