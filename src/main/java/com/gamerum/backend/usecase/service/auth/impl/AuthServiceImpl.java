package com.gamerum.backend.usecase.service.auth.impl;

import com.gamerum.backend.adaptor.dto.auth.LoginRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.LoginResponse;
import com.gamerum.backend.adaptor.dto.auth.RegisterRequestDTO;
import com.gamerum.backend.adaptor.dto.response.auth.RegisterResponse;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.entity.User;
import com.gamerum.backend.external.persistence.relational.repository.UserRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.service.auth.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponse register(RegisterRequestDTO request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.ROLE_USER)
                .build();

        Profile profile = Profile.builder()
                .nickname(request.getNickname())
                .user(user)
                .build();

        user.setProfile(profile);
        userRepository.save(user);

        return new RegisterResponse(true, "Registration successful!");
    }

    @Override
    public LoginResponse login(LoginRequestDTO request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = jwtUtil.generateToken(auth);
        return new LoginResponse(true,"Login successful","Bearer", token);
    }
}
