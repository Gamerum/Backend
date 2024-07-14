package com.gamerum.backend.service.auth.impl;

import com.gamerum.backend.security.auth.request.LoginRequest;
import com.gamerum.backend.security.auth.response.LoginResponse;
import com.gamerum.backend.security.auth.request.RegisterRequest;
import com.gamerum.backend.security.auth.response.RegisterResponse;
import com.gamerum.backend.entity.Profile;
import com.gamerum.backend.entity.User;
import com.gamerum.backend.repository.UserRepository;
import com.gamerum.backend.service.auth.AuthService;
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
    public RegisterResponse register(RegisterRequest request) {

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

        return RegisterResponse.builder()
                .success(true)
                .message("Registration successful!")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        /*
        * It will be implemented when security system added because authentication will be done with it.
        */

        return null;
    }
}
