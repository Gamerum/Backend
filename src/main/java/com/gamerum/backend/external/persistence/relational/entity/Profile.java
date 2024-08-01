package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.ProfileSyncListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Profiles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "displayName"),
                @UniqueConstraint(columnNames = "user_id")
        }
)
@EntityListeners(ProfileSyncListener.class)
public class Profile extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private boolean isActive;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommunityMember> joinedCommunities;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Post> posts;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ChatParticipant> participatedChats;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Message> messages;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reply> commentRespons;
}
