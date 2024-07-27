package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Override
    public Chat getByChatId(Long chatId) {
        Optional<Chat> chat = chatRepository.findByIdWithParticipants(chatId);
        if(chat.isEmpty())
            throw new RuntimeException();
        return chat.get();
    }

    @Override
    public Chat createChat(ChatCreateDTO chat) {
        Profile creator = profileRepository.findById(chat.getCreatorProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class, "ID", chat.getCreatorProfileId()));

        Chat newChat = chatRepository.save(new Chat(creator.getId()));

        //Set Chat Admin
        ChatParticipant admin = chatParticipantRepository.save(new ChatParticipant(creator, newChat, true));
        newChat.getParticipants().add(admin);

        //Set Chat Participants
        if (chat.getParticipantProfileIds() != null) {
            List<ChatParticipant> chatParticipants = chat.getParticipantProfileIds().stream()
                    .map(id -> profileRepository.findById(id).orElseThrow(() ->
                            new NotFoundException(Profile.class, "ID", id)))
                    .map(profile -> new ChatParticipant(profile, newChat,false))
                    .toList();
            List<ChatParticipant> participants = (List<ChatParticipant>) chatParticipantRepository.saveAll(chatParticipants);
            newChat.getParticipants().addAll(participants);
        }

        return newChat;
    }

    @Override
    public void deleteChat(Long chatId) {
       chatRepository.deleteById(chatId);
    }

    @Override
    public List<Chat> getChats(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chatRepository.findAll(pageable).getContent();
    }
}
