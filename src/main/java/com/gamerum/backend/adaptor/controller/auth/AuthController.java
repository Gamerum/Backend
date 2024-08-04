package com.gamerum.backend.adaptor.controller.auth;

import com.gamerum.backend.adaptor.dto.auth.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.RegisterRequestDTO;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@Validated @RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Validated @RequestBody LoginRequestDTO request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
}
