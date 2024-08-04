package com.gamerum.backend.adaptor.controller.user;

import com.gamerum.backend.adaptor.dto.user.ChangeEmailDTO;
import com.gamerum.backend.adaptor.dto.user.ChangePasswordDTO;
import com.gamerum.backend.usecase.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{userId}/change_email")
    public ResponseEntity<String> changeEmail(@PathVariable Long userId, @Validated @RequestBody ChangeEmailDTO changeEmailDTO) {
        return new ResponseEntity<>(userService.changeEmail(changeEmailDTO, userId), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{userId}/change_password")
    public ResponseEntity changePassword(@PathVariable Long userId, @Validated @RequestBody ChangePasswordDTO changePasswordDTO) throws CredentialException {
        userService.changePassword(changePasswordDTO, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
