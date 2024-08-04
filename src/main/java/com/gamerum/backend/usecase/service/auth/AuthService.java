package com.gamerum.backend.usecase.service.auth;

import com.gamerum.backend.adaptor.dto.auth.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.auth.RegisterRequestDTO;

import java.util.Map;

public interface AuthService {
    void register(RegisterRequestDTO request);
    Map<String, String> login(LoginRequestDTO request);
}
