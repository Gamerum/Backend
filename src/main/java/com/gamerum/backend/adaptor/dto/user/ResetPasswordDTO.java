package com.gamerum.backend.adaptor.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
* We need to create a token to let user change its password and the client must send this token.
* This token must be kept in db and has a relation with the user entity.
*/

@Getter
@AllArgsConstructor
public class ResetPasswordDTO {
    private String token;
    private String newPassword;
}
