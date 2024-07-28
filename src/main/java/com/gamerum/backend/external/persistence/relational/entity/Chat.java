package com.gamerum.backend.external.persistence.relational.entity;

import com.gamerum.backend.external.persistence.relational.audit.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Chats")
public class Chat extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ChatParticipant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Message> messages = new ArrayList<>();
}
