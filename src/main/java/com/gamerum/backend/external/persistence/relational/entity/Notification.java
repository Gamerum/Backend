package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.relational.NotificationListener;
import com.gamerum.backend.adaptor.content.notification.NotificationContent;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Notifications")
@EntityListeners(NotificationListener.class)
public class Notification extends Auditable {
    public enum Type {
        COMMENT_READ
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notified_profile_id", nullable = false)
    private Profile notifiedProfile;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @Column(nullable = false)
    private String content;

    @Transient
    private NotificationContent notificationContent;
}
