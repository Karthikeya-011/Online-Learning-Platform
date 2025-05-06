package com.learningplatfrom;

import java.util.Map;  // Import Map
import java.util.HashMap;  // Import HashMap
import java.util.ArrayList;  // Import ArrayList
import java.util.List;  // Import List

public class CourseRating {
    // Store ratings for users (user -> course -> rating)
    private Map<String, Map<String, Integer>> userRatings = new HashMap<>();

    // Constructor to initialize some sample data
    public CourseRating() {
        // Sample ratings (user -> course -> rating)
        Map<String, Integer> user1Ratings = new HashMap<>();
        user1Ratings.put("Java", 5);
        user1Ratings.put("Machine Learning", 4);
        userRatings.put("user1", user1Ratings);
        
        Map<String, Integer> user2Ratings = new HashMap<>();
        user2Ratings.put("HTML", 5);
        user2Ratings.put("CSS", 4);
        userRatings.put("user2", user2Ratings);
    }

    // Method to get course recommendations based on ratings (user ID as a String)
    public List<String> getRecommendationsBasedOnRatings(int userId) {
        // Convert the userId to String
        String userIdStr = "user" + userId;  // Assumes user ID format is like "user1", "user2", etc.
        
        Map<String, Integer> ratings = userRatings.get(userIdStr);
        List<String> recommendedCourses = new ArrayList<>();
        
        if (ratings != null) {
            for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                if (entry.getValue() >= 4) {  // Recommend courses with rating >= 4
                    recommendedCourses.add(entry.getKey() + " (Rating: " + entry.getValue() + ")");
                }
            }
        }
        
        return recommendedCourses;
    }
}
