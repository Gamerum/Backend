package com.gamerum.backend.adaptor.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
* This dto is not used for change the user's email directly.
* It is used to create a token and send this token to the new email address in a link.
* This token must be kept in the database.
*/

@Getter
@AllArgsConstructor
public class ChangeEmailDTO {
    private Long userId;
    private String newEmail;
}
