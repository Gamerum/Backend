package com.gamerum.backend.adaptor.dto.auth;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    @Size(min = 6, max = 30, message = MessageCode.SIZE_EXCEPTION_6_30)
    private String username;

    @Size(min = 6, max = 30, message = MessageCode.SIZE_EXCEPTION_6_30)
    private String nickname;

    @Email(message = MessageCode.INCORRECT_EMAIL_PATTERN)
    private String email;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = MessageCode.INCORRECT_PASSWORD_PATTERN
    )
    private String password;
}
