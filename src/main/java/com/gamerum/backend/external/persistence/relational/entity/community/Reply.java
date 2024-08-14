package com.gamerum.backend.external.persistence.relational.entity.community;

import com.gamerum.backend.adaptor.consumer.ReplyListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import com.gamerum.backend.external.persistence.relational.entity.user.Profile;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "Replies")
@EntityListeners(ReplyListener.class)
public class Reply extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "respond_comment_id", updatable = false, nullable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile writer;
}
