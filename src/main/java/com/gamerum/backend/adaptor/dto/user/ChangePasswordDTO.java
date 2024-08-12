package com.gamerum.backend.adaptor.dto.user;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDTO {
    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = MessageCode.INCORRECT_PASSWORD_PATTERN
    )
    private String currentPassword;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$",
            message = MessageCode.INCORRECT_PASSWORD_PATTERN
    )
    private String newPassword;
}
