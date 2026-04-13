package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return repo.save(user);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        User existing = repo.findByUsername(user.getUsername());

        return existing != null &&
               existing.getPassword().equals(user.getPassword());
    }
}