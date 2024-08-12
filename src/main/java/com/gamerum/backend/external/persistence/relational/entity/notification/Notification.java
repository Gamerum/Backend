package com.gamerum.backend.external.persistence.relational.entity.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gamerum.backend.adaptor.consumer.NotificationListener;
import com.gamerum.backend.external.persistence.relational.entity.notification.content.NotificationContent;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import com.gamerum.backend.external.persistence.relational.entity.user.Profile;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Notifications")
@EntityListeners(NotificationListener.class)
public class Notification extends Auditable implements Serializable {
    public enum Type {
        COMMENT_READ
    }

    private static final long serialVersionUID = 1L;

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
    @JsonIgnore
    private NotificationContent notificationContent;
}
