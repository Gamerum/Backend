package com.gamerum.backend.usecase.service.user.impl;

import com.gamerum.backend.adaptor.dto.user.ChangeEmailDTO;
import com.gamerum.backend.adaptor.dto.user.ChangePasswordDTO;
import com.gamerum.backend.external.persistence.relational.entity.User;
import com.gamerum.backend.external.persistence.relational.repository.UserRepository;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import com.gamerum.backend.usecase.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String changeEmail(ChangeEmailDTO changeEmailDTO, Long userId) {
        if (!Objects.equals(currentUser.getUserId(), userId))
            throw new NotAllowedException();

        User user = userRepository.findById(userId).
                orElseThrow(() -> new NotFoundException("User"));

        user.setEmail(changeEmailDTO.getNewEmail());
        return userRepository.save(user).getEmail();
    }

    @Override
    public void changePassword(ChangePasswordDTO changePasswordDTO, Long userId) throws CredentialException {
        if (!Objects.equals(currentUser.getUserId(), userId))
            throw new NotAllowedException();

        User user = userRepository.findById(userId).
                orElseThrow(() -> new NotFoundException("User"));

        if (!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), user.getPassword()))
            throw new CredentialException();

        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }
}
