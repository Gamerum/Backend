package com.gamerum.backend.usecase.service.message;

import com.gamerum.backend.external.persistence.entity.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    void deleteByIdMessage(Long messageId);
    List<Message> getAllMessages(Long chatId);
}
