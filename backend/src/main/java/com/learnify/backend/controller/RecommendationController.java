package com.learnify.backend.controller;

import com.learnify.backend.recomendation.CourseRecommendation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RecommendationController {

    @GetMapping("/recommendations")
    public List<String> getRecommendations(@RequestParam int userId) {
        CourseRecommendation recommender = new CourseRecommendation();
        return recommender.getRecommendedCourses(userId);
    }
}
