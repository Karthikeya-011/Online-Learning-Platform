package com.learnify.backend.recomendation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.learnify.backend.db.DatabaseConnection;

public class CourseRecommendation {
    public List<String> getRecommendedCourses(int userId) {
        List<String> recommendedCourses = new ArrayList<>();
        String query = "SELECT c.title FROM courses c JOIN enrollments e ON c.course_id = e.course_id WHERE e.user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                recommendedCourses.add(resultSet.getString("title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recommendedCourses;
    }
}


