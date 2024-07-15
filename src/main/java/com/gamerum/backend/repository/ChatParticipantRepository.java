package com.gamerum.backend.repository;

import com.gamerum.backend.entity.ChatParticipant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatParticipantRepository extends CrudRepository<ChatParticipant, Long> {
}
