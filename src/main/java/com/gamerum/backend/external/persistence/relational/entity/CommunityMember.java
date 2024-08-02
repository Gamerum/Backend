package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch.CommunityMemberListener;
import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CommunityMembers")
@EntityListeners(CommunityMemberListener.class)
public class CommunityMember extends Auditable{
    public enum Role {
        OWNER,
        MOD,
        USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "community_id", nullable = false, updatable = false)
    private Community community;
}
