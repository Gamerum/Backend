package com.gamerum.backend.usecase.service.auth.impl;

import com.gamerum.backend.domain.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.LoginResponseDTO;
import com.gamerum.backend.domain.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.RegisterResponseDTO;
import com.gamerum.backend.external.persistence.entity.Profile;
import com.gamerum.backend.external.persistence.entity.User;
import com.gamerum.backend.external.persistence.repository.UserRepository;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO request) {

        Profile profile = Profile.builder()
                .nickname(request.getNickname())
                .build();

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .profile(profile)
                .build();

        userRepository.save(user);

        return RegisterResponseDTO.builder()
                .success(true)
                .message("Registration successful!")
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        /*
        * It will be implemented when security system added because authentication will be done with it.
        */

        return null;
    }
}
