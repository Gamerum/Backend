package com.gamerum.backend.usecase.kafka.consumer;

import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;
import com.gamerum.backend.usecase.websocket.WebsocketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationConsumer {
    private final WebsocketService websocketService;

    @Value("${spring.kafka.topic.notification}")
    private String topic;

    public KafkaNotificationConsumer(WebsocketService websocketService) {
        this.websocketService = websocketService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.notification}", groupId = "${spring.kafka.group.notification}")
    public void Listen(Notification notification) {
        String destination = "/topic/" + topic + "/" + notification.getNotifiedProfile().getId();
        websocketService.sendNotification(destination, notification);
    }
}
