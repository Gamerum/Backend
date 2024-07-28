package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Chat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("SELECT c FROM Chat c JOIN FETCH c.participants JOIN FETCH c.messages WHERE c.id = :id")
    Optional<Chat> findByIdWithParticipantsAndMessages(Long id);

    @Query("SELECT DISTINCT c FROM Chat c " +
            "JOIN FETCH c.participants p " +
            "JOIN FETCH c.messages m " +
            "WHERE c.id = :chatId AND p.profile.id = :profileId")
    Optional<Chat> findByIdWithParticipantsAndMessagesAndProfileId(Long chatId, Long profileId);

    @Query("SELECT c FROM Chat c JOIN c.participants p WHERE p.profile.id = :profileId")
    List<Chat> findChatsByProfileId(Long profileId, Pageable pageable);
}
