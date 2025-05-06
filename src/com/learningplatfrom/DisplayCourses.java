package com.learningplatfrom;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DisplayCourses {
	    public static void main(String[] args) {
	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM courses";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            System.out.println("=== Available Courses ===");
	            while (rs.next()) {
	                System.out.println("Course ID: " + rs.getInt("course_id"));
	                System.out.println("Title: " + rs.getString("title"));
	                System.out.println("Description: " + rs.getString("description"));
	                System.out.println("Instructor: " + rs.getString("instructor"));
	                System.out.println("---------------------------");
	            }
	        } catch (SQLException e) {
	            System.out.println("❌ Database error:");
	            e.printStackTrace();
	        }
	    }
	}
