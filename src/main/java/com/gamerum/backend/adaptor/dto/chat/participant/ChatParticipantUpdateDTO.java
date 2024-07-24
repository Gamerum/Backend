package com.gamerum.backend.adaptor.dto.chat.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatParticipantUpdateDTO {
    private Long participantProfileId;
    private Long chatId;
    private Long updaterProfileId;
    private boolean isAdmin;
}
