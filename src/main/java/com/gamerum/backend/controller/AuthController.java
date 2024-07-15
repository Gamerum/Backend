package com.gamerum.backend.controller;

import com.gamerum.backend.security.auth.request.LoginRequest;
import com.gamerum.backend.security.auth.request.RegisterRequest;
import com.gamerum.backend.security.auth.response.LoginResponse;
import com.gamerum.backend.security.auth.response.RegisterResponse;
import com.gamerum.backend.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/public/auth/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/api/public/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @GetMapping("/api/public/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
