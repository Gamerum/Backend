package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.*;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.MessageService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
    @Autowired
    private CurrentUser currentUser;

    @Override
    public Message createMessage(Long chatId, MessageCreateDTO messageCreateDTO) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat"));

        Profile profile = profileRepository.findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new NotParticipatedException();

        return messageRepository.save(
                Message.builder()
                        .chat(chat)
                        .profile(profile)
                        .text(messageCreateDTO.getText())
                        .isSent(messageCreateDTO.isSent())
                .build());
    }

    @Override
    public void deleteByIdMessage(Long chatId, Long messageId) {
        Message message = messageRepository.findByIdAndChatId(messageId, chatId)
                .orElseThrow(() -> new NotFoundException("Message"));

        if (currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            messageRepository.deleteById(messageId);
            return;
        }

        Long profileId = currentUser.getProfileId();

        if (Objects.equals(message.getProfile().getId(), profileId)) {
            messageRepository.deleteById(messageId);
            return;
        }

        ChatParticipant chatParticipant = chatParticipantRepository.findByChatIdAndProfileId(chatId, profileId)
                .orElseThrow(NotParticipatedException::new);

        if (!chatParticipant.isAdmin())
            throw new NotAllowedException();

        messageRepository.deleteById(messageId);
    }

    @Override
    public List<Message> getAllMessages(Long chatId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (currentUser.hasRole(UserRole.ROLE_ADMIN))
            return messageRepository.findByChatId(chatId, pageable);

        if (!chatParticipantRepository.existsByChatIdAndProfileId(chatId, currentUser.getProfileId()))
            throw new NotParticipatedException();

        return messageRepository.findByChatId(chatId, pageable);
    }

    @Override
    public Message updateMessage(Long chatId, MessageUpdateDTO messageUpdateDTO) {
        Message message = messageRepository.findByIdAndChatId(messageUpdateDTO.getId(), chatId)
                .orElseThrow(() -> new NotFoundException("Message"));

        message.setText(messageUpdateDTO.getMessage());

        if (!Objects.equals(message.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        return messageRepository.save(message);
    }
}
