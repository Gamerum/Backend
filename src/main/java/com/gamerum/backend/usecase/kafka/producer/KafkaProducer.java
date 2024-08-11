package com.gamerum.backend.usecase.kafka.producer;

public interface KafkaProducer<T> {
    void sendToKafka(T object);
}
