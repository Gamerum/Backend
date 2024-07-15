package com.gamerum.backend.service.Impl;

import com.gamerum.backend.entity.Chat;
import com.gamerum.backend.entity.ChatParticipant;
import com.gamerum.backend.entity.Message;
import com.gamerum.backend.repository.ChatParticipantRepository;
import com.gamerum.backend.repository.ChatRepository;
import com.gamerum.backend.repository.MessageRepository;
import com.gamerum.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Chat getByChatId(Long id) {
        Optional<Chat> chat = chatRepository.findById(id);
        if(chat.isEmpty())
            throw new RuntimeException();
        return chat.get();
    }

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChat(Long id) {
       chatRepository.deleteById(id);
    }

    @Override
    public List<Chat> getChats() {
        return (List<Chat>) chatRepository.findAll();
    }

    @Override
    public ChatParticipant createChatParticipant(ChatParticipant chatParticipant) {
        return chatParticipantRepository.save(chatParticipant);
    }

    @Override
    public void deleteByIdChatParticipant(Long id) {
        chatParticipantRepository.deleteById(id);
    }

    @Override
    public ChatParticipant getChatParticipantId(Long id) {
        Optional<ChatParticipant> chatParticipant = chatParticipantRepository.findById(id);
        if(chatParticipant.isEmpty())
            throw new RuntimeException();
        return chatParticipant.get();
    }

    @Override
    public List<ChatParticipant> getChatParticipants() {
        return (List<ChatParticipant>) chatParticipantRepository.findAll();
    }

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
