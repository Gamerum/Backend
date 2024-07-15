package com.gamerum.backend.repository;

import com.gamerum.backend.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByChatId(@Param("chat_id") Long chatID);
}
