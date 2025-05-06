package com.learningplatfrom;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class UpdateUserProfile {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            System.out.println("Enter your User ID to update profile:");
	            int userId = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            System.out.println("Enter your new Name:");
	            String name = scanner.nextLine();

	            System.out.println("Enter your new Email:");
	            String email = scanner.nextLine();

	            // SQL query to update the user profile
	            String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            pstmt.setString(2, email);
	            pstmt.setInt(3, userId);

	            int rowsUpdated = pstmt.executeUpdate();

	            if (rowsUpdated > 0) {
	                System.out.println("🎯 Profile updated successfully!");
	            } else {
	                System.out.println("❌ Profile update failed! Check your User ID.");
	            }

	        } catch (SQLException e) {
	            System.out.println("❌ Database error:");
	            e.printStackTrace();
	        } finally {
	            scanner.close();
	        }
	    }
	}

