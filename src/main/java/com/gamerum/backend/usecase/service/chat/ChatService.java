package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat getByChatId(long chatId, String token);
    Chat createChat(ChatCreateDTO chat);
    void deleteChat(Long chatId, String token);
    List<Chat> getChats(String token, int page, int size, long profileId);
}
