package com.gamerum.backend.adaptor.dto.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChatGetDTO {
    private Long id;
    private List<ChatParticipantGetDTO> participants;
    private List<MessageGetDTO> messages;
}