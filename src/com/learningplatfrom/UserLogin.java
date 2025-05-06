package com.learningplatfrom;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class UserLogin {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("=== User Login ===");
	        System.out.print("Enter Email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter Password: ");
	        String password = scanner.nextLine();

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                System.out.println("✅ Login successful! Welcome, " + rs.getString("name"));
	            } else {
	                System.out.println("❌ Invalid email or password!");
	            }
	        } catch (SQLException e) {
	            System.out.println("❌ Database error:");
	            e.printStackTrace();
	        }
	    }
	}

