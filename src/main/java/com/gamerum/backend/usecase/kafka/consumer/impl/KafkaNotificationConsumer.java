package com.gamerum.backend.usecase.kafka.consumer.impl;

import com.gamerum.backend.usecase.kafka.consumer.KafkaConsumer;
import com.gamerum.backend.external.persistence.relational.entity.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class KafkaNotificationConsumer implements KafkaConsumer<Notification> {
    private final SimpMessagingTemplate messagingTemplate;

    @Value("${spring.kafka.topic.notification}")
    private String topic;

    public KafkaNotificationConsumer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    @KafkaListener(topics = "${spring.kafka.topic.notification}", groupId = "${spring.kafka.group.notification}")
    public void Listen(Notification notification) {
        String destination = "/topic/" + topic + "/" + notification.getNotifiedProfile().getId();
        messagingTemplate.convertAndSend(destination, notification);
    }
}
