package com.learningplatfrom;

import java.util.*;


public class CourseRecommendationML {

    // Simulated machine learning recommendation system
    public List<String> getRecommendedCoursesUsingML(int userId) {
        List<String> recommendedCourses = new ArrayList<>();
        
        // Convert userId (int) to a string for comparison
        String userIdString = String.valueOf(userId);
        
        if (userIdString.equals("1")) {
            recommendedCourses.add("Machine Learning with Python");
            recommendedCourses.add("Deep Learning with TensorFlow");
        } else if (userIdString.equals("2")) {
            recommendedCourses.add("Web Development");
            recommendedCourses.add("JavaScript Mastery");
        } else {
            recommendedCourses.add("Java Programming");
            recommendedCourses.add("Data Science Essentials");
        }
        
        return recommendedCourses;
    }
}



	

