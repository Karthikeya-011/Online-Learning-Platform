package com.learningplatfrom;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class UserRegistration {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter your name:");
	        String name = scanner.nextLine();

	        System.out.println("Enter your email:");
	        String email = scanner.nextLine();

	        System.out.println("Enter your password:");
	        String password = scanner.nextLine();

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setString(3, password);

	            int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("User registered successfully!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        scanner.close();
	    }
	}

