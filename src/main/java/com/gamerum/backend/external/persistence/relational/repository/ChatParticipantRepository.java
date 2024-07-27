package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatParticipantRepository extends JpaRepository<ChatParticipant, Long> {
    boolean existsByChatIdAndProfileId(Long chatId, Long profileId);
    Optional<ChatParticipant> findByChatIdAndProfileId(Long chatId, Long profileId);
    List<ChatParticipant> findByChatId(Long chatId, Pageable pageable);
}
