package com.gamerum.backend.external.persistence.relational.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CommunityMembers")
public class CommunityMember {
    public enum CommunityMemberRole {
        OWNER,
        MOD,
        USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;


    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private CommunityMemberRole role;

    @Setter(AccessLevel.NONE)
    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @Column(name = "joined_by_profile_id")
    private long joinedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by_profile_id")
    private Long updatedBy;

    public CommunityMember() {
        joinedAt = LocalDateTime.now();
    }
}
