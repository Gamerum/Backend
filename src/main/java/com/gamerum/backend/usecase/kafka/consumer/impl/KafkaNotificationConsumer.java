package com.gamerum.backend.usecase.kafka.consumer.impl;

import com.gamerum.backend.usecase.kafka.consumer.KafkaConsumer;
import com.gamerum.backend.external.persistence.relational.entity.Notification;
import com.gamerum.backend.usecase.websocket.WebsocketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaNotificationConsumer implements KafkaConsumer<Notification> {
    private final WebsocketService websocketService;

    @Value("${spring.kafka.topic.notification}")
    private String topic;

    public KafkaNotificationConsumer(WebsocketService websocketService) {
        this.websocketService = websocketService;
    }

    @Override
    @KafkaListener(topics = "${spring.kafka.topic.notification}", groupId = "${spring.kafka.group.notification}")
    public void Listen(Notification notification) {
        String destination = "/topic/" + topic + "/" + notification.getNotifiedProfile().getId();
        websocketService.sendNotification(destination, notification);
    }
}
