package com.gamerum.backend.adaptor.controller.chat;

import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageUpdateDTO;
import com.gamerum.backend.adaptor.mapper.chat.MessageMapper;
import com.gamerum.backend.usecase.service.chat.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    @MessageMapping("/chat/{chatId}/sendMessage")
    public ResponseEntity<MessageGetDTO> addMessage(@PathVariable Long chatId, @Validated @RequestBody MessageCreateDTO messageCreateDTO) {
        return new ResponseEntity<>(MessageMapper.INSTANCE.messageToMessageGetDTO(messageService.createMessage(chatId, messageCreateDTO)), HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/api/chat/{chatId}/messages")
    public ResponseEntity deleteMessage(@PathVariable Long chatId, @RequestParam Long messageId) {
        messageService.deleteByIdMessage(chatId, messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/api/chat/{chatId}/messages")
    public ResponseEntity<List<MessageGetDTO>> getAllMessages(@PathVariable Long chatId, @RequestParam(defaultValue = "0") Integer page) {
        return new ResponseEntity<>(MessageMapper.INSTANCE.messagesToMessageGetDTOs(messageService.getAllMessages(chatId, page)), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/api/chat/{chatId}/messages")
    public ResponseEntity<MessageGetDTO> updateMessage(@PathVariable Long chatId, @Validated @RequestBody MessageUpdateDTO messageUpdateDTO) {
        return new ResponseEntity<>(MessageMapper.INSTANCE.messageToMessageGetDTO(messageService.updateMessage(chatId, messageUpdateDTO)), HttpStatus.OK);
    }
}
