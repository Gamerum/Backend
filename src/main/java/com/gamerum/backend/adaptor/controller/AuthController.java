package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.domain.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.domain.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.LoginResponseDTO;
import com.gamerum.backend.domain.dto.auth.response.RegisterResponseDTO;
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
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/api/public/auth/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @GetMapping("/api/public/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
