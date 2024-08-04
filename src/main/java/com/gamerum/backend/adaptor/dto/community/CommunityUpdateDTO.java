package com.gamerum.backend.adaptor.dto.community;

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
public class CommunityUpdateDTO {
    @Size(min = 6, max = 30, message = ErrorCode.SIZE_EXCEPTION_6_30)
    private String title;

    @Size(min = 1, max = 255, message = ErrorCode.SIZE_EXCEPTION_1_255)
    private String description;
}
