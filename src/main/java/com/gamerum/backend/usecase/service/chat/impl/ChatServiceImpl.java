package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Chat getByChatId(Long id) {
        Optional<Chat> chat = chatRepository.findById(id);
        if(chat.isEmpty())
            throw new RuntimeException();
        return chat.get();
    }

    @Override
    public Chat createChat(ChatCreateDTO chat) {
        Optional<Profile> creator = profileRepository.findById(chat.getCreatorProfileId());
        if (creator.isEmpty()) throw new RuntimeException();
        Profile creatorProfile = creator.get();

        Chat newChat = chatRepository.save(new Chat(creatorProfile.getId()));
        //Set Chat Admin
        chatParticipantRepository.save(new ChatParticipant(creatorProfile,newChat,true));

        //Set Chat Participants
        List<ChatParticipant> chatParticipants = chat.getProfileIds().stream()
                .map(id -> profileRepository.findById(id))
                .filter(Optional::isPresent)
                .map(profile -> new ChatParticipant(profile.get(),newChat,false))
                .toList();

        chatParticipantRepository.saveAll(chatParticipants);
        return newChat;
    }

    @Override
    public void deleteChat(Long id) {
       chatRepository.deleteById(id);
    }

    @Override
    public List<Chat> getChats() {
        return (List<Chat>) chatRepository.findAll();
    }
}
