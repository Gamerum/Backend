package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.CommunitySyncListener;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Communities",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        }
)
@EntityListeners(CommunitySyncListener.class)
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private String tags;
    private long clickCount;
    private long gameId;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
    private Set<CommunityMember> members = new HashSet<>();

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by_profile_id", nullable = false)
    private long createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by_profile_id")
    private Long updatedBy;

    public Community() {
        createdAt = LocalDateTime.now();
    }
}
