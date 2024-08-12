package com.gamerum.backend.usecase.kafka.producer.impl;

import com.gamerum.backend.usecase.kafka.producer.KafkaProducer;
import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaNotificationProducer implements KafkaProducer<Notification> {
    @Autowired
    private KafkaTemplate<String, Notification> kafkaTemplate;

    @Value("${spring.kafka.topic.notification}")
    private String topic;

    @Override
    public void sendToKafka(Notification notification) {
        kafkaTemplate.send(topic, notification);
    }
}
