package com.gamerum.backend.usecase.service.notification.impl;

import com.gamerum.backend.external.persistence.relational.entity.Notification;
import com.gamerum.backend.external.persistence.relational.repository.NotificationRepository;
import com.gamerum.backend.usecase.service.notification.NotificationService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final CurrentUser currentUser;
    private final NotificationRepository notificationRepository;
    private final KafkaTemplate<String, Notification> kafkaTemplate;

    @Value("${spring.kafka.topics.notification}")
    private String topic;

    @Value("${profile.notification.size}")
    private int notificationPageSize;

    public NotificationServiceImpl(CurrentUser currentUser, NotificationRepository notificationRepository,
                                   KafkaTemplate<String, Notification> kafkaTemplate) {
        this.currentUser = currentUser;
        this.notificationRepository = notificationRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendProfileNotifications(int page) {
        notificationRepository
                .findByNotifiedProfileIdSortByCreatedDateDesc(currentUser.getProfileId(),
                        PageRequest.of(page, notificationPageSize))
                .forEach(n -> kafkaTemplate.send(topic, n));
    }

    @Override
    public void sendAndSaveNotification(Notification notification) {
        notificationRepository.save(notification);
        kafkaTemplate.send(topic, notification);
    }

    @Override
    public Long getNotificationCountOfProfile(Long profileId) {
        return notificationRepository.countByNotifiedProfileId(profileId);
    }

    @Override
    public void deleteNotificationOfCurrentUser(Long notificationId) {
        notificationRepository.deleteByIdAndProfileId(notificationId, currentUser.getProfileId());
    }

    @Override
    public void deleteAllNotificationsOfCurrentUser() {
        notificationRepository.deleteAllByProfileId(currentUser.getProfileId());
    }
}
