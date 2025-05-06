package com.learningplatfrom;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their User ID
        System.out.println("Enter User ID to get course recommendations:");
        String userIdInput = scanner.nextLine();  // Read the user input

        try {
            // Parse the user input into an integer
            int userId = Integer.parseInt(userIdInput);

            // Initialize all recommendation strategies
            CourseRecommendation courseRecommendation = new CourseRecommendation();
            CourseRating courseRating = new CourseRating();
            CoursePopularity coursePopularity = new CoursePopularity();
            CourseRecommendationML courseRecommendationML = new CourseRecommendationML();

            // Get basic recommendations (assuming this returns List<String>)
            List<String> basicRecommendations = courseRecommendation.getRecommendedCourses(userId);
            System.out.println("Basic Course Recommendations: " + String.join(", ", basicRecommendations));

            // Get recommendations based on ratings (assuming this returns List<String>)
            List<String> ratingRecommendations = courseRating.getRecommendationsBasedOnRatings(userId);
            System.out.println("Recommended Courses Based on Ratings: " + String.join(", ", ratingRecommendations));

            // Get popular courses (assuming this returns List<String>)
            List<String> popularCourses = coursePopularity.getPopularCourses();
            System.out.println("Popular Courses: " + String.join(", ", popularCourses));

            // Get machine learning-based recommendations (assuming this returns List<String>)
            List<String> mlRecommendations = courseRecommendationML.getRecommendedCoursesUsingML(userId);
            System.out.println("Machine Learning-based Recommendations: " + String.join(", ", mlRecommendations));

        } catch (NumberFormatException e) {
            // Handle invalid user ID input
            System.out.println("Invalid User ID. Please enter a numeric value.");
        } finally {
            // Close the scanner to avoid resource leaks
            scanner.close();
        }
    }
}




	
