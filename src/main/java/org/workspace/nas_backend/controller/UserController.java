package org.workspace.nas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workspace.nas_backend.model.User;
import org.workspace.nas_backend.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User newUser) {
        // Check if username already exists
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return new ResponseEntity<>("Username already exists!", HttpStatus.CONFLICT);
        }

        // Save the new user to the database
        userRepository.save(newUser);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return true;
        }
        return false;
    }
}
