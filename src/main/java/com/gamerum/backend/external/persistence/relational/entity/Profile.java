package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.ProfileSyncListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@EntityListeners({ProfileSyncListener.class, AuditingEntityListener.class})
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
    private List<CommunityMember> joinedCommunities;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<ChatParticipant> participatedChats;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Message> messages;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    private Long lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
