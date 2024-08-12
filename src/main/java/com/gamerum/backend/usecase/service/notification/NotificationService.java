package com.gamerum.backend.usecase.service.notification;

import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;

public interface NotificationService {
    void sendProfileNotifications(int page);
    void deleteNotificationOfCurrentUser(Long notificationId);
    void deleteAllNotificationsOfCurrentUser();
    void sendAndSaveNotification(Notification notification);
    Long getNotificationCountOfProfile(Long profileId);
}
