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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    @Value("${page.message.size}")
    private int messagePageSize;

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final ProfileRepository profileRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final CurrentUser currentUser;

    public MessageServiceImpl(MessageRepository messageRepository, ChatRepository chatRepository, ProfileRepository profileRepository, ChatParticipantRepository chatParticipantRepository, CurrentUser currentUser) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.profileRepository = profileRepository;
        this.chatParticipantRepository = chatParticipantRepository;
        this.currentUser = currentUser;
    }

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

        if (!currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            Long deleterProfileId = currentUser.getProfileId();

            if (!message.getProfile().getId().equals(deleterProfileId)) {
                ChatParticipant deleter = chatParticipantRepository
                        .findByChatIdAndProfileId(chatId, deleterProfileId)
                        .orElseThrow(NotParticipatedException::new);

                if (!deleter.isMod()) throw new NotAllowedException();
            }
        }
        messageRepository.delete(message);
    }

    @Override
    public List<Message> getAllMessages(Long chatId, int page) {
        if (!currentUser.hasRole(UserRole.ROLE_ADMIN) &&
                !chatParticipantRepository.existsByChatIdAndProfileId(chatId, currentUser.getProfileId()))
            throw new NotAllowedException();

        return messageRepository.findByChatId(chatId, PageRequest.of(page, messagePageSize));
    }

    @Override
    public Message updateMessage(Long chatId, MessageUpdateDTO messageUpdateDTO) {
        Message message = messageRepository.findByIdAndChatId(messageUpdateDTO.getId(), chatId)
                .orElseThrow(() -> new NotFoundException("Message"));

        if (!Objects.equals(message.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        message.setText(messageUpdateDTO.getMessage());
        return messageRepository.save(message);
    }
}
