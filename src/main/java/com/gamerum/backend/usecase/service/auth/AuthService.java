package com.gamerum.backend.usecase.service.auth;

import com.gamerum.backend.domain.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.domain.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.LoginResponseDTO;
import com.gamerum.backend.domain.dto.auth.response.RegisterResponseDTO;

public interface AuthService {
    RegisterResponseDTO register(RegisterRequestDTO request);
    LoginResponseDTO login(LoginRequestDTO request);
}
