package com.cognizant.springlearn.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.jwt.JwtUtil;

@RestController
public class AuthenticationController {

    private final JwtUtil jwtUtil = new JwtUtil();

    @GetMapping("/authenticate")
    public String authenticate(Authentication authentication) {

        return jwtUtil.generateToken(authentication.getName());

    }
}