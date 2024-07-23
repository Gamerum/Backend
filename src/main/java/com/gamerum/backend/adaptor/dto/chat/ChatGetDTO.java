package com.gamerum.backend.adaptor.dto.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ChatGetDTO {
    private Long id;
    private List<ChatParticipantGetDTO> chatParticipants;
    private List<MessageGetDTO> messages;
}