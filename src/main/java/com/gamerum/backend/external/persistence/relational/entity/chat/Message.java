package com.gamerum.backend.external.persistence.relational.entity.chat;

import com.gamerum.backend.adaptor.consumer.MessageListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import com.gamerum.backend.external.persistence.relational.entity.user.Profile;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Messages")
@EntityListeners(MessageListener.class)
public class Message extends Auditable {
    public enum Type {
        USER,
        SYSTEM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean isSent;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false, updatable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
}
