package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.CommunitySyncListener;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
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
    @Column(nullable = false)
    private String gameId;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
    private List<CommunityMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

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
