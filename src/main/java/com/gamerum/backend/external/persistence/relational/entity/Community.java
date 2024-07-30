package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.CommunitySyncListener;
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
@Table(name = "Communities",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        }
)
@EntityListeners(CommunitySyncListener.class)
public class Community extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private String tags;

    private long clickCount;

    @Column(nullable = false, updatable = false)
    private String gameId;

    @Transient
    @OneToMany(mappedBy = "community")
    private List<CommunityMember> members;

    @Transient
    @OneToMany(mappedBy = "community")
    private List<Post> posts;
}
