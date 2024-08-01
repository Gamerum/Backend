package com.gamerum.backend.adaptor.controller.auth;

import com.gamerum.backend.adaptor.dto.auth.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.LoginResponse;
import com.gamerum.backend.adaptor.dto.response.auth.RegisterResponse;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequestDTO request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDTO request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
}
