package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.ProfileSyncListener;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Profiles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "displayName"),
                @UniqueConstraint(columnNames = "user_id")
        }
)
@EntityListeners(ProfileSyncListener.class)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private boolean isActive;

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<CommunityMember> joinedCommunities = new ArrayList<>();

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<ChatParticipant> participatedChats = new ArrayList<>();

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Message> messages = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by_profile_id")
    private Long updatedBy;

    public Profile() {
        createdAt = LocalDateTime.now();
    }
}
