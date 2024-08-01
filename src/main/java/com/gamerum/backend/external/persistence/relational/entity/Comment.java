package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "Comments")
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Transient
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CommentResponse> responses;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
}
