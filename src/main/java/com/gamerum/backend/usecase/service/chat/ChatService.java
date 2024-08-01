package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat getByChatId(Long chatId);
    Chat createChat(ChatCreateDTO chat);
    void deleteChat(Long chatId);
    List<Chat> getChats(int page, int size, Long profileId);
}
