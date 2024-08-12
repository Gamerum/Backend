package com.gamerum.backend.adaptor.dto.chat.participant;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatParticipantCreateDTO {
    @NotNull(message = MessageCode.NOT_NULL)
    private Long profileId;
}
