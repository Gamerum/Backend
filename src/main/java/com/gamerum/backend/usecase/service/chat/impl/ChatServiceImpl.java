package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.ChatService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Value("${page.chat.participants_size}")
    private int participantPageSize;

    @Value("${page.chat.messages_size}")
    private int messagesPageSize;

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private CurrentUser currentUser;

    @Override
    @Transactional(readOnly = true)
    public Chat getByChatId(long chatId) {
        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isMemberOfTheChat = chatParticipantRepository
                .existsByChatIdAndProfileId(chatId, currentUser.getProfileId());

        if (!isAdmin && !isMemberOfTheChat)
            throw new NotAllowedException();

        Chat chat =  chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat not found"));

        List<ChatParticipant> participants = chatParticipantRepository
                .findByChatId(chatId, PageRequest.of(0, participantPageSize));
        List<Message> messages = messageRepository
                .findByChatId(chatId, PageRequest.of(0, messagesPageSize));

        chat.setParticipants(participants);
        chat.setMessages(messages);

        return chat;
    }

    @Override
    @Transactional
    public Chat createChat(ChatCreateDTO chat) {
        Profile creator = profileRepository.findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        Chat newChat = chatRepository.save(new Chat());

        //Set Chat Admin
        ChatParticipant admin = chatParticipantRepository.save(
                ChatParticipant.builder()
                        .profile(creator)
                        .chat(newChat)
                        .isAdmin(true)
                        .build());

        newChat.getParticipants().add(admin);

        //Set Chat Participants
        if (chat.getParticipantProfileIds() != null) {
            List<ChatParticipant> chatParticipants = chat.getParticipantProfileIds().stream()
                    .map(id -> profileRepository.findById(id).orElseThrow(() ->
                            new NotFoundException("Profile")))
                    .map(profile -> ChatParticipant.builder()
                            .profile(profile)
                            .chat(newChat)
                            .isAdmin(false)
                            .build())
                    .toList();

            List<ChatParticipant> participants = chatParticipantRepository.saveAll(chatParticipants);
            newChat.getParticipants().addAll(participants);
        }

        return newChat;
    }

    @Override
    public void deleteChat(Long chatId) {
        if (currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            chatRepository.deleteById(chatId);
            return;
        }

        ChatParticipant deleter = chatParticipantRepository
                .findByChatIdAndProfileId(chatId, currentUser.getProfileId())
                .orElseThrow(NotParticipatedException::new);

        if (!deleter.isAdmin())
            throw new NotAllowedException();

        chatRepository.deleteById(chatId);
    }

    @Override
    public List<Chat> getChats(int page, int size, long profileId) {
        Pageable pageable = PageRequest.of(page, size);

        if (profileId > 0 && currentUser.hasRole(UserRole.ROLE_ADMIN))
            return chatParticipantRepository.findChatsByProfileId(profileId, pageable);

        return chatParticipantRepository.findChatsByProfileId(currentUser.getProfileId(), pageable);
    }
}
