package com.gamerum.backend.adaptor.dto.user;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ForgetPasswordDTO {
    @Size(min = 6, max = 30, message = MessageCode.SIZE_EXCEPTION_6_30)
    private String username;

    @Email(message = MessageCode.INCORRECT_EMAIL_PATTERN)
    private String email;
}
