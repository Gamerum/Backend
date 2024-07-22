package com.gamerum.backend.usecase.service.auth.impl;

import com.gamerum.backend.domain.dto.auth.request.LoginRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.LoginResponseDTO;
import com.gamerum.backend.domain.dto.auth.request.RegisterRequestDTO;
import com.gamerum.backend.domain.dto.auth.response.RegisterResponseDTO;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.entity.User;
import com.gamerum.backend.external.persistence.relational.repository.UserRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Profile profile = new Profile();
        profile.setNickname(request.getNickname());
        profile.setUser(user);

        user.setProfile(profile);
        userRepository.save(user);

        return RegisterResponseDTO.builder()
                .success(true)
                .message("Registration successful!")
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = jwtUtil.generateToken(auth);
        return LoginResponseDTO.builder()
                .success(true)
                .message("Logged in successfully.")
                .token(token)
                .tokenType("Bearer")
                .build();
    }
}
