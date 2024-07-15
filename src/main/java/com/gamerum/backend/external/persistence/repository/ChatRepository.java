package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
}
