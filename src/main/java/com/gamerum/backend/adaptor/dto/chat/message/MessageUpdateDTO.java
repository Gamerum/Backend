package com.gamerum.backend.adaptor.dto.chat.message;

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
public class MessageUpdateDTO {
    @NotNull(message = ErrorCode.NOT_NULL)
    private Long id;

    @Size(min = 1, max = 255, message = ErrorCode.SIZE_EXCEPTION_1_255)
    private String text;
}
