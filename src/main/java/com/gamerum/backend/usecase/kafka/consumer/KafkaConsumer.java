package com.gamerum.backend.usecase.kafka.consumer;

public interface KafkaConsumer<T> {
    void Listen(T object);
}
