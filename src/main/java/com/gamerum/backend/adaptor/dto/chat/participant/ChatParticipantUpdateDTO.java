package com.gamerum.backend.adaptor.dto.chat.participant;

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
public class ChatParticipantUpdateDTO {
    @NotNull(message = ErrorCode.NOT_NULL)
    private Long id;

    private boolean isMod;
}
