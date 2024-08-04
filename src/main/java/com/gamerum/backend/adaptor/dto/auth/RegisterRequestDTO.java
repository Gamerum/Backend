package com.gamerum.backend.adaptor.dto.auth;

import com.gamerum.backend.usecase.exception.ErrorCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    @Size(min = 6, max = 30, message = ErrorCode.SIZE_EXCEPTION_6_30)
    private String username;

    @Size(min = 6, max = 30, message = ErrorCode.SIZE_EXCEPTION_6_30)
    private String nickname;

    @Email(message = ErrorCode.INCORRECT_EMAIL_PATTERN)
    private String email;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = ErrorCode.INCORRECT_PASSWORD_PATTERN
    )
    private String password;
}
