package com.gamerum.backend.adaptor.mapper.chat;

import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ChatParticipantMapper.class, MessageMapper.class})
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    ChatGetDTO chatToChatGetDTO(Chat chat);
}
