package com.learningplatfrom;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class ViewEnrolledCourses {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            System.out.println("Enter your User ID to view enrolled courses:");
	            int userId = scanner.nextInt();

	            // Query to get courses for a specific user
	            String sql = "SELECT courses.title, courses.description, courses.instructor " +
	                         "FROM courses " +
	                         "JOIN enrollments ON courses.course_id = enrollments.course_id " +
	                         "WHERE enrollments.user_id = ?";

	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, userId);

	            ResultSet rs = pstmt.executeQuery();

	            System.out.println("=== Enrolled Courses ===");
	            if (!rs.isBeforeFirst()) {
	                System.out.println("No courses found for this user.");
	            } else {
	                while (rs.next()) {
	                    System.out.println("Title: " + rs.getString("title"));
	                    System.out.println("Description: " + rs.getString("description"));
	                    System.out.println("Instructor: " + rs.getString("instructor"));
	                    System.out.println("---------------------------");
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("❌ Database error:");
	            e.printStackTrace();
	        } finally {
	            scanner.close();
	        }
	    }
	}

