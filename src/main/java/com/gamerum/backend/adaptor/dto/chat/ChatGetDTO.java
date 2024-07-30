package com.gamerum.backend.adaptor.dto.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGetDTO {
    private Long id;
    private List<ChatParticipantGetDTO> participants;
    private List<MessageGetDTO> messages;
}