package com.learnify.backend.controller;

import com.learnify.backend.model.LoginRequest;
import com.learnify.backend.model.LoginResponse;
import com.learnify.backend.model.User;
import com.learnify.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow access from frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.loginUser(
            loginRequest.getUserId(), loginRequest.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok(new LoginResponse(true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false));
        }
    }
}


