package com.gamerum.backend.external.persistence.relational.entity.chat;

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
public class Message extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean isSent;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false, updatable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
}
