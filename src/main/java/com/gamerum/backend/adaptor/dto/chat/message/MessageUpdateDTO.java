package com.gamerum.backend.adaptor.dto.chat.message;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageUpdateDTO {
    @NotNull(message = MessageCode.NOT_NULL)
    private Long id;

    @Size(min = 1, max = 255, message = MessageCode.SIZE_EXCEPTION_1_255)
    private String text;
}
