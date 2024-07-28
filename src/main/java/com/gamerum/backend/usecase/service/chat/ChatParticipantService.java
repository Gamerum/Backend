package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO);
    void deleteByIdChatParticipant(Long chatId, Long chatParticipantId, String token);
    List<ChatParticipant> getChatParticipants(Long chatId, int page, int size, String token);
    ChatParticipant updateChatParticipant(long chatId, ChatParticipantUpdateDTO chatParticipantUpdateDTO, String token);
}
