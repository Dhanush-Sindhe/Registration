package com.tap;

import java.sql.*;
import java.util.Scanner;

public class Program2 {

    private static final String URL = "jdbc:mysql://localhost:3306/internassesment";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    

    // VALIDATION
    private static boolean isValidPhone(String phoneNum) {
        return phoneNum.matches("\\d{10}");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    
    
    

    // CREATE
    public static void createRegistration(int id, String name, String email, String dob, String phoneNum) {
        // Validate 
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        if (!isValidPhone(phoneNum)) {
            System.out.println("Phone number must be a 10-digit number.");
            return;
        }

        String query = "INSERT INTO registration (id, name, email, dob, phonenum) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setDate(4, Date.valueOf(dob));  //YYYY-MM-DD
            stmt.setString(5, phoneNum);

            stmt.executeUpdate();
            System.out.println("Registration created successfully!");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    

    // READ
    public static void readRegistration(int id) {
        String query = "SELECT * FROM registration WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Date of Birth: " + rs.getDate("dob"));
                System.out.println("Phone Number: " + rs.getString("phonenum"));
            } else {
                System.out.println("Registration not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    

    // UPDATE
    public static void updateRegistration(int id, String name, String email, String phoneNum) {
        
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        if (!isValidPhone(phoneNum)) {
            System.out.println("Phone number must be a 10-digit number.");
            return;
        }

        String query = "UPDATE registration SET name = ?, email = ?, phonenum = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNum);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Registration updated.");
            } else {
                System.out.println("Registration not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public static void deleteRegistration(int id) {
        String query = "DELETE FROM registration WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registration deleted.");
            } else {
                System.out.println("Registration not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Choose an operation:\n 1. Create 2. Read 3. Update 4. Delete");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter ID, Name, Email, DOB (YYYY-MM-DD), Phone:");
                int id = scanner.nextInt();
                String name = scanner.next();
                String email = scanner.next();
                String dob = scanner.next();
                String phoneNum = scanner.next();
                createRegistration(id, name, email, dob, phoneNum);
                break;
            case 2:
                System.out.println("Enter ID to read:");
                readRegistration(scanner.nextInt());
                break;
            case 3:
                System.out.println("Enter ID, Name, Email, Phone to update:");
                updateRegistration(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next());
                break;
            case 4:
                System.out.println("Enter ID to delete:");
                deleteRegistration(scanner.nextInt());
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
