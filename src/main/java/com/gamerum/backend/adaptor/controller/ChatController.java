package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.ChatMapper;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import com.gamerum.backend.usecase.service.chat.ChatService;
import com.gamerum.backend.usecase.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatParticipantService chatParticipantService;
    @Autowired
    private MessageService messageService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long chatId) {
        return new ResponseEntity<>(chatService.getByChatId(chatId), HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<ChatGetDTO>> createChat(@RequestBody ChatCreateDTO chatCreateDTO) {
        Chat newChat = chatService.createChat(chatCreateDTO);
        return new ResponseEntity<>(new ResponseData<>(true,
                "Chat created!",
                ChatMapper.INSTANCE.chatToChatGetDTO(newChat)),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long chatId) {
        chatService.deleteChat(chatId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public ResponseEntity<List<Chat>> getChats() {
        return new ResponseEntity<>(chatService.getChats(), HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/participants")
    public ResponseEntity<ChatParticipant> addChatParticipant(@RequestBody ChatParticipant chatParticipant) {
        return new ResponseEntity<>(chatParticipantService.createChatParticipant(chatParticipant), HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/participants/{id}")
    public ResponseEntity<Void> deleteChatParticipant(@PathVariable Long chatParticipantId) {
        chatParticipantService.deleteByIdChatParticipant(chatParticipantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/participants/{id}")
    public ResponseEntity<ChatParticipant> getChatParticipantById(@PathVariable Long chatParticipantId) {
        return new ResponseEntity<>(chatParticipantService.getChatParticipantId(chatParticipantId), HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/participants")
    public ResponseEntity<List<ChatParticipant>> getChatParticipants() {
        return new ResponseEntity<>(chatParticipantService.getChatParticipants(),HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.createMessage(message),HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long mesaageId) {
        messageService.deleteByIdMessage(mesaageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/messages/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.getAllMessages(chatId),HttpStatus.OK);
    }
}