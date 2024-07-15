package com.gamerum.backend.controller;

import com.gamerum.backend.entity.Chat;
import com.gamerum.backend.entity.ChatParticipant;
import com.gamerum.backend.entity.Message;
import com.gamerum.backend.service.ChatService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
        return new ResponseEntity<>(chatService.getByChatId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        return new ResponseEntity<>(chatService.createChat(chat), HttpStatus.CREATED);
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
        return new ResponseEntity<>(chatService.createChatParticipant(chatParticipant), HttpStatus.CREATED);
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<Void> deleteChatParticipant(@PathVariable Long id) {
        chatService.deleteByIdChatParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/participants/{id}")
    public ResponseEntity<ChatParticipant> getChatParticipantById(@PathVariable Long id) {
        return new ResponseEntity<>(chatService.getChatParticipantId(id), HttpStatus.OK);
    }

    @GetMapping("/participants")
    public ResponseEntity<List<ChatParticipant>> getChatParticipants() {
        return new ResponseEntity<>(chatService.getChatParticipants(),HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(chatService.createMessage(message),HttpStatus.CREATED);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        chatService.deleteByIdMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable Long id) {
        return new ResponseEntity<>(chatService.getAllMessages(id),HttpStatus.OK);
    }
}