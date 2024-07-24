package com.gamerum.backend.adaptor.dto.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class ChatGetDTO {
    private Long id;
    private Set<ChatParticipantGetDTO> participants;
    private List<MessageGetDTO> messages;
}