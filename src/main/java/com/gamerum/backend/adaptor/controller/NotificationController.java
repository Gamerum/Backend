package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.usecase.service.notification.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/load")
    public ResponseEntity triggerNotifications(@RequestParam(defaultValue = "0") Integer page) {
        notificationService.sendProfileNotifications(page);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteNotification(@RequestParam Long notificationId) {
        notificationService.deleteNotificationOfCurrentUser(notificationId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/all")
    public ResponseEntity deleteNotification() {
        notificationService.deleteAllNotificationsOfCurrentUser();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
