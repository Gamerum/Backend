package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Chat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
    @Query("SELECT c FROM Chat c JOIN FETCH c.participants WHERE c.id = :id")
    Optional<Chat> findByIdWithParticipants(@Param("id") Long id);
}
