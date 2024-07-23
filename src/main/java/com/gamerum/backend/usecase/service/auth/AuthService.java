package com.gamerum.backend.usecase.service.auth;

import com.gamerum.backend.adaptor.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.response.LoginResponseDTO;
import com.gamerum.backend.adaptor.dto.auth.response.RegisterResponseDTO;

public interface AuthService {
    RegisterResponseDTO register(RegisterRequestDTO request);
    LoginResponseDTO login(LoginRequestDTO request);
}
