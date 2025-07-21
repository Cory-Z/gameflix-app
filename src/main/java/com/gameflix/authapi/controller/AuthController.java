package com.gameflix.authapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gameflix.authapi.model.User;
import com.gameflix.authapi.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        String message = userService.register(user);
        return Map.of("message", message);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        String message = userService.login(user);
        return Map.of("message", message);
    }
}
