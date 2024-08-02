package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Long chatId, MessageCreateDTO messageCreateDTO);
    void deleteByIdMessage(Long chatId, Long messageId);
    List<Message> getAllMessages(Long chatId, int page);
    Message updateMessage(Long chatId, MessageUpdateDTO messageUpdateDTO);
}
