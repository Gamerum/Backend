package com.gamerum.backend.adaptor.dto.chat.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatParticipantGetDTO {
    private Long id;
    private String nickname;
    private boolean isAdmin;
}
