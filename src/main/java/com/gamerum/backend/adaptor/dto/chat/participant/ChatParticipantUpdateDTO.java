package com.gamerum.backend.adaptor.dto.chat.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatParticipantUpdateDTO {
    private Long id;
    private boolean isAdmin;
}
