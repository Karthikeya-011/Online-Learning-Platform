package com.learnify.backend.controller;

	public class EnrollmentRequest {
	    private int userId;
	    private int courseId;

	    // Getters and Setters
	    public int getUserId() {
	        return userId;
	    }
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    public int getCourseId() {
	        return courseId;
	    }
	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }
	}

