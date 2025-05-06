package com.learnify.backend;

import org.springframework.web.bind.annotation.*;

import java.util.Map;



import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/test") // Change the base path to avoid conflicts
public class MyController {

    private List<Map<String, String>> userList = new ArrayList<>();

    @PostMapping("/create")
    public String createUser(@RequestBody Map<String, String> user) {
        userList.add(user);
        return "Test user created!";
    }

    @GetMapping("/dummy-users") // Unique path
    public List<Map<String, String>> getUsers() {
        return userList;
    }
}



