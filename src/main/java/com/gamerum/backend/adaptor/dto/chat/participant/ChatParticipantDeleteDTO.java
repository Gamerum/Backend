package com.gamerum.backend.adaptor.dto.chat.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatParticipantDeleteDTO {
    private Long chatId;
    private Long participantProfileId;
    private Long deleterProfileId;
}
