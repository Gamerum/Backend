package com.gamerum.backend.adaptor.dto.user;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * We need to create a token to let user change its password and the client must send this token.
 * This token must be kept in db and has a relation with the user entity.
 */

@Getter
@AllArgsConstructor
public class ResetPasswordDTO {
    @NotNull(message = MessageCode.NOT_NULL)
    @NotBlank(message = MessageCode.NOT_BLANK)
    private String token;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = MessageCode.INCORRECT_PASSWORD_PATTERN
    )
    private String newPassword;
}
