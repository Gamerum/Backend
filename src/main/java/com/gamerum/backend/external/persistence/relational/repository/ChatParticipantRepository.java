package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChatParticipantRepository extends CrudRepository<ChatParticipant, Long> {
    boolean existsByChatIdAndProfileId(Long chatId, Long profileId);
}
