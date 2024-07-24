package com.gamerum.backend.usecase.service.auth;

import com.gamerum.backend.adaptor.dto.auth.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.LoginResponse;
import com.gamerum.backend.adaptor.dto.response.auth.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequestDTO request);
    LoginResponse login(LoginRequestDTO request);
}
