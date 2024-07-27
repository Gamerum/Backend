package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Override
    public Message createMessage(Long chatId, MessageCreateDTO messageCreateDTO) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat"));

        Profile profile = profileRepository.findById(messageCreateDTO.getSenderProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new NotParticipatedException();

        return messageRepository.save(
                new Message(chat, profile, messageCreateDTO.getText(), messageCreateDTO.isSent()));
    }

    @Override
    public void deleteByIdMessage(Long chatId, Long messageId, Long deleterId) {
        Message message = messageRepository.findByIdAndChatId(messageId, chatId)
                        .orElseThrow(() -> new NotFoundException("Message"));

        if (Objects.equals(message.getProfile().getId(), deleterId)){
            messageRepository.deleteById(messageId);
            return;
        }

        // delete by admin
        ChatParticipant chatParticipant = chatParticipantRepository.findByChatIdAndProfileId(chatId, deleterId)
                .orElseThrow(NotParticipatedException::new);

        if (!chatParticipant.isAdmin())
            throw new NotAllowedException();

        messageRepository.deleteById(messageId);
    }

    @Override
    public List<Message> getAllMessages(Long chatId) {
        return messageRepository.findByChatId(chatId);
    }
}
