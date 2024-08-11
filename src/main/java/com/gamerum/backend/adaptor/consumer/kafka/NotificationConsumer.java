package com.gamerum.backend.adaptor.consumer.kafka;

import com.gamerum.backend.external.persistence.relational.entity.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    private final SimpMessagingTemplate messagingTemplate;

    public NotificationConsumer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "${spring.kafka.topic.notification}",
            groupId = "${spring.kafka.group.notification}")
    public void listenCommentReplyNotificationEvent(Notification notification) {
        String destination = "/topic/notifications/" + notification.getNotifiedProfile().getId();
        messagingTemplate.convertAndSend(destination, notification);
    }
}