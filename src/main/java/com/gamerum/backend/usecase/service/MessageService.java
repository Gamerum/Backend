package com.gamerum.backend.usecase.service;

import com.gamerum.backend.external.persistence.entity.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    void deleteByIdMessage(Long id);
    List<Message> getAllMessages(Long id);
}
