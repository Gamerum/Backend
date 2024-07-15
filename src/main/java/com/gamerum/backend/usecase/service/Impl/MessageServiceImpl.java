package com.gamerum.backend.usecase.service.Impl;

import com.gamerum.backend.external.persistence.entity.Message;
import com.gamerum.backend.external.persistence.repository.MessageRepository;
import com.gamerum.backend.usecase.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
   @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteByIdMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> getAllMessages(Long id) {
        return messageRepository.findByChatId(id);
    }
}
