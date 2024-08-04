package com.gamerum.backend.adaptor.dto.user.profile;

import com.gamerum.backend.usecase.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDTO {
    @NotNull(message = ErrorCode.NOT_NULL)
    private Long id;

    @Size(min = 6, max = 30, message = ErrorCode.SIZE_EXCEPTION_6_30)
    private String nickname;
}
