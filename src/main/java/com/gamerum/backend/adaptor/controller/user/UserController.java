package com.gamerum.backend.adaptor.controller.user;

import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.dto.user.ChangeEmailDTO;
import com.gamerum.backend.adaptor.dto.user.ChangePasswordDTO;
import com.gamerum.backend.usecase.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/{userId}/change_email")
    public ResponseEntity<ResponseData<String>> changeEmail(
            @PathVariable Long userId,
            @RequestBody ChangeEmailDTO changeEmailDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Email changed.",
                userService.changeEmail(changeEmailDTO,userId)),
                HttpStatus.OK);
    }

    @PutMapping("/{userId}/change_password")
    public ResponseEntity<Response> changePassword(
            @PathVariable Long userId,
            @RequestBody ChangePasswordDTO changePasswordDTO) throws CredentialException {
        userService.changePassword(changePasswordDTO,userId);
        return new ResponseEntity<>(new Response(
                true,
                "Password changed."),
                HttpStatus.OK);
    }
}
