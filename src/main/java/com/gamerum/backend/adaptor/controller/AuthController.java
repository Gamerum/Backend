package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.LoginResponse;
import com.gamerum.backend.adaptor.dto.response.auth.RegisterResponse;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/public/auth/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequestDTO request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/api/public/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDTO request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
}
