package com.gamerum.backend.usecase.service.user.impl;

import com.gamerum.backend.adaptor.dto.user.ChangeEmailDTO;
import com.gamerum.backend.adaptor.dto.user.ChangePasswordDTO;
import com.gamerum.backend.external.persistence.relational.entity.User;
import com.gamerum.backend.external.persistence.relational.repository.UserRepository;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import com.gamerum.backend.usecase.service.user.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String changeEmail(ChangeEmailDTO changeEmailDTO, Long userId) {
        if (!currentUser.getUserId().equals(userId)) throw new NotAllowedException();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User"));

        user.setEmail(changeEmailDTO.getNewEmail());
        return userRepository.save(user).getEmail();
    }

    @Override
    public void changePassword(ChangePasswordDTO changePasswordDTO, Long userId) throws CredentialException {
        if (!currentUser.getUserId().equals(userId)) throw new NotAllowedException();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User"));

        if (!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), user.getPassword()))
            throw new CredentialException();

        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }
}
