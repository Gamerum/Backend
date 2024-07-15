package com.gamerum.backend.service;

import com.gamerum.backend.entity.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    void deleteByIdMessage(Long id);
    List<Message> getAllMessages(Long id);
}
