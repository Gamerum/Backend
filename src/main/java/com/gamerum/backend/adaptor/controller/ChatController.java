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

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
        return new ResponseEntity<>(chatService.getByChatId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseData<ChatGetDTO>> createChat(@RequestBody ChatCreateDTO chatCreateDTO) {
        Chat newChat = chatService.createChat(chatCreateDTO);
        return new ResponseEntity<>(new ResponseData<>(true,
                "Chat created!",
                ChatMapper.INSTANCE.chatToChatGetDTO(newChat)),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getChats() {
        return new ResponseEntity<>(chatService.getChats(), HttpStatus.OK);
    }

    @PostMapping("/participants")
    public ResponseEntity<ChatParticipant> addChatParticipant(@RequestBody ChatParticipant chatParticipant) {
        return new ResponseEntity<>(chatParticipantService.createChatParticipant(chatParticipant), HttpStatus.CREATED);
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<Void> deleteChatParticipant(@PathVariable Long id) {
        chatParticipantService.deleteByIdChatParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/participants/{id}")
    public ResponseEntity<ChatParticipant> getChatParticipantById(@PathVariable Long id) {
        return new ResponseEntity<>(chatParticipantService.getChatParticipantId(id), HttpStatus.OK);
    }

    @GetMapping("/participants")
    public ResponseEntity<List<ChatParticipant>> getChatParticipants() {
        return new ResponseEntity<>(chatParticipantService.getChatParticipants(),HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.createMessage(message),HttpStatus.CREATED);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteByIdMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.getAllMessages(id),HttpStatus.OK);
    }
}