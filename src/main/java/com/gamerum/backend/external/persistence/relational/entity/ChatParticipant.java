package com.gamerum.backend.external.persistence.relational.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ChatParticipants")
public class ChatParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Setter(AccessLevel.NONE)
    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @Column(name = "joined_by_profile_id")
    private long joinedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by_profile_id")
    private Long updatedBy;

    public ChatParticipant(Profile profile, Chat chat, long joinedBy, boolean isAdmin) {
        this.profile = profile;
        this.chat = chat;
        this.isAdmin = isAdmin;
        joinedAt = LocalDateTime.now();
    }
}
