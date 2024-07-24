package com.gamerum.backend.adaptor.dto.chat.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatParticipantDeleteDTO {
    private Long id;
    private Long deleterProfileId;
}
