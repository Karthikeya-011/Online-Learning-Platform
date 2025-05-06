package com.learnify.backend;

	import org.springframework.web.bind.annotation.*;
	import java.util.*;

	@RestController
	@RequestMapping("/api/courses")
	@CrossOrigin(origins = "*")  // Allows your HTML pages to fetch from this
	public class CourseController {

	    @GetMapping
	    public List<Course> getCourses() {
	        List<Course> courses = new ArrayList<>();
	        courses.add(new Course(1, "Python Basics", "Learn Python from scratch"));
	        courses.add(new Course(2, "Java Full Stack", "Master frontend and backend"));
	        courses.add(new Course(3, "Machine Learning", "Intro to ML algorithms"));
	        return courses;
	    }
	}

