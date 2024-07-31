package com.gamerum.backend.adaptor.mapper.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(source = "profile.id", target = "senderProfileId")
    @Mapping(source = "profile.nickname", target = "senderName")
    @Mapping(source = "createdDate", target = "sendDate")
    @Mapping(source = "sent", target = "isSent")
    MessageGetDTO messageToMessageGetDTO(Message message);

    List<MessageGetDTO> messagesToMessageGetDTOs(List<Message> messages);
}
