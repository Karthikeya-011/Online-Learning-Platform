package com.learningplatfrom;

		import java.util.*;

		public class CoursePopularity {
		    private Map<String, Integer> coursePopularity = new HashMap<>();

		    // Constructor with sample course popularity data
		    public CoursePopularity() {
		        // Sample course popularity (course -> number of enrollments)
		        coursePopularity.put("Java", 500);
		        coursePopularity.put("Machine Learning", 300);
		        coursePopularity.put("Data Science", 450);
		        coursePopularity.put("Web Development", 600);
		    }

		    // Method to get popular courses based on enrollments
		    public List<String> getPopularCourses() {
		        List<String> popularCourses = new ArrayList<>();
		        
		        // Sort courses by popularity in descending order
		        coursePopularity.entrySet().stream()
		            .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
		            .forEach(entry -> 
		                popularCourses.add(entry.getKey() + " (Popularity: " + entry.getValue() + " enrollments)")
		            );
		        
		        return popularCourses;
		    }
		}
