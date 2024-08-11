package com.gamerum.backend.usecase.service.notification.impl;

import com.gamerum.backend.external.persistence.relational.entity.Notification;
import com.gamerum.backend.external.persistence.relational.repository.NotificationRepository;
import com.gamerum.backend.usecase.kafka.producer.impl.KafkaNotificationProducer;
import com.gamerum.backend.usecase.service.notification.NotificationService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl extends KafkaNotificationProducer implements NotificationService {
    private final CurrentUser currentUser;
    private final NotificationRepository notificationRepository;

    @Value("${profile.notification.size}")
    private int notificationPageSize;

    public NotificationServiceImpl(CurrentUser currentUser, NotificationRepository notificationRepository) {
        super();
        this.currentUser = currentUser;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendProfileNotifications(int page) {
        notificationRepository
                .findByNotifiedProfileIdOrderByCreatedDateDesc(currentUser.getProfileId(),
                        PageRequest.of(page, notificationPageSize)).forEach(this::sendToKafka);
    }

    @Override
    public void sendAndSaveNotification(Notification notification) {
        notificationRepository.save(notification);
        sendToKafka(notification);
    }

    @Override
    public Long getNotificationCountOfProfile(Long profileId) {
        return notificationRepository.countByNotifiedProfileId(profileId);
    }

    @Override
    public void deleteNotificationOfCurrentUser(Long notificationId) {
        notificationRepository.deleteByIdAndNotifiedProfileId(notificationId, currentUser.getProfileId());
    }

    @Override
    public void deleteAllNotificationsOfCurrentUser() {
        notificationRepository.deleteAllByNotifiedProfileId(currentUser.getProfileId());
    }
}
