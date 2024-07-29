package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import com.gamerum.backend.security.user.UserRole;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }
)
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean isActive;

    @Column(nullable = false)
    private UserRole role;

    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Profile profile;
}
