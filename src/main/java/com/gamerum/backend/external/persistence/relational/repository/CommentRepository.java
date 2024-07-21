package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
