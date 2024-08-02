package com.gamerum.backend.usecase.service.user;

import com.gamerum.backend.adaptor.dto.user.ChangeEmailDTO;
import com.gamerum.backend.adaptor.dto.user.ChangePasswordDTO;

import javax.security.auth.login.CredentialException;

public interface UserService {
    String changeEmail(ChangeEmailDTO changeEmailDTO, Long userId);
    void changePassword(ChangePasswordDTO changePasswordDTO, Long userId) throws CredentialException;
}
