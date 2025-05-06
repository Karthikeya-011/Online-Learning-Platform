package com.learningplatfrom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRecommendationUI {
    // Example of how you might implement the method to get course recommendations from DB
    public static String getCourseRecommendationsFromDB(String userId) {
        String query = "SELECT c.title FROM courses c JOIN enrollments e ON c.id = e.course_id WHERE e.user_id = ?";
        StringBuilder recommendations = new StringBuilder();

        try (Connection connection = DatabaseConnection.getConnection(); // Use DatabaseConnection here
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, userId);  // Assuming userId is a string; adjust if necessary
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                recommendations.append(rs.getString("title")).append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Handle exceptions as needed
        }

        return recommendations.toString();
    }

    public static void main(String[] args) {
        // your code to create UI and handle events
    }
}



