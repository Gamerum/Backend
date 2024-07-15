package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.ChatParticipant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatParticipantRepository extends CrudRepository<ChatParticipant, Long> {
}
