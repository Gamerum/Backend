package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO);
    void deleteByIdChatParticipant(Long chatId, Long chatParticipantId);
    List<ChatParticipant> getChatParticipants(Long chatId, int page, int size);
    ChatParticipant updateChatParticipant(long chatId, ChatParticipantUpdateDTO chatParticipantUpdateDTO);
}
