package com.gamerum.backend.external.persistence.relational.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "respond_comment_id")
    private Comment responseTo;

    @OneToMany(mappedBy = "responseTo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> responses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by_profile_id")
    private Long updatedBy;

    public Comment() {
        createdAt = LocalDateTime.now();
    }
}
