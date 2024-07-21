package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatParticipantRepository extends CrudRepository<ChatParticipant, Long> {
}
