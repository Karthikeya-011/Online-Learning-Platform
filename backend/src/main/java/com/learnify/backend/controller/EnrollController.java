package com.learnify.backend.controller;

	import com.learnify.backend.model.EnrollmentRequest;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.PersistenceContext;
	import jakarta.transaction.Transactional;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/api")
	public class EnrollController {

	    @PersistenceContext
	    private EntityManager entityManager;

	    @PostMapping("/enroll")
	    @Transactional
	    public ResponseEntity<String> enroll(@RequestBody EnrollmentRequest req) {
	        entityManager.createNativeQuery("INSERT INTO enrollments (user_id, course_id) VALUES (?, ?)")
	                .setParameter(1, req.getUserId())
	                .setParameter(2, req.getCourseId())
	                .executeUpdate();
	        return ResponseEntity.ok("Enrollment successful!");
	    }
	}

