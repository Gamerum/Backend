package com.gamerum.backend.adaptor.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamerum.backend.external.persistence.relational.entity.notification.content.CommentReplyNotificationContent;
import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;

public class NotificationListener {
    private final ObjectMapper objectMapper;

    public NotificationListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PrePersist
    private void encodeContent(Notification notification) throws JsonProcessingException {
        if (notification.getNotificationContent() != null)
            notification.setContent(objectMapper.writeValueAsString(notification.getNotificationContent()));
    }

    @PostUpdate
    private void decodeContent(Notification notification) throws JsonProcessingException {
        switch (notification.getType()) {
            case COMMENT_READ: notification.setNotificationContent(
                    objectMapper.readValue(notification.getContent(), CommentReplyNotificationContent.class));
                break;
        }
    }
}
