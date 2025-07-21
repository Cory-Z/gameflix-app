package com.gameflix.authapi.service;

import com.gameflix.authapi.model.User;
import com.gameflix.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(u -> passwordEncoder.matches(user.getPassword(), u.getPassword()) ? "Login successful" : "Invalid username or password")
                .orElse("Invalid username or password");
    }
}