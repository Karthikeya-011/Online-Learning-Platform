package com.learningplatfrom;

import java.sql.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRecommendation {

	public List<String> getRecommendedCourses(int userId) {
	    List<String> recommendedCourses = new ArrayList<>();
	    String query = "SELECT c.title " +
	                   "FROM courses c " +
	                   "JOIN enrollments e ON c.course_id = e.course_id " + // Make sure course_id is used here
	                   "WHERE e.user_id = ?"; // Use parameterized query to avoid SQL injection

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, userId); // Set the userId parameter
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String courseTitle = resultSet.getString("title");
	            recommendedCourses.add(courseTitle);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return recommendedCourses;
	}
}


