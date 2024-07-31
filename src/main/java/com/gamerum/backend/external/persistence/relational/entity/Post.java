package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.PostSyncListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Posts")
@EntityListeners(PostSyncListener.class)
public class Post extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tag;

    private String text;

    private long clickCount;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false, updatable = false)
    private Community community;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;

    @Transient
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments;
}
