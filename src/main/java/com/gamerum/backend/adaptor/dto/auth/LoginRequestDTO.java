package com.gamerum.backend.adaptor.dto.auth;

import com.gamerum.backend.usecase.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @Size(min = 6, max = 30, message = ErrorCode.SIZE_EXCEPTION_6_30)
    private String username;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = ErrorCode.INCORRECT_PASSWORD_PATTERN
    )
    private String password;
}
