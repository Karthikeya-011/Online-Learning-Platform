package com.learnify.backend.model;

	public class EnrollmentRequest {
	    private int userId;
	    private int courseId;

	    // Getter and Setter for userId
	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    // Getter and Setter for courseId
	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }
	}

