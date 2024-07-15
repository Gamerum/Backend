package com.gamerum.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DeletedUsers")
public class DeletedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @Setter(AccessLevel.NONE)
    @Column(name = "deleted_at", nullable = false)
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by_profile_id")
    private long deletedBy;

    @Column(name = "deletion_reason", nullable = false)
    private String deletionReason;

    public DeletedUser() {
        deletedAt = LocalDateTime.now();
    }
}
