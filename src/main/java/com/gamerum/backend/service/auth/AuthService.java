package com.gamerum.backend.service.auth;

import com.gamerum.backend.security.auth.request.LoginRequest;
import com.gamerum.backend.security.auth.request.RegisterRequest;
import com.gamerum.backend.security.auth.response.LoginResponse;
import com.gamerum.backend.security.auth.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
