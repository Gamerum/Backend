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

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<CommunityMember> joinedCommunities;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Post> posts;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<ChatParticipant> participatedChats;

    @Transient
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Message> messages;
}
