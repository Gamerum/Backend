package com.gamerum.backend.usecase.service.auth;

import com.gamerum.backend.adaptor.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.LoginResponse;
import com.gamerum.backend.adaptor.dto.response.auth.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequestDTO request);
    LoginResponse login(LoginRequestDTO request);
}
