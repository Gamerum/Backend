package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<Comment> findByIdAndPostId(Long id, Long postId);
    List<Comment> findByPostId(Long postId, Pageable pageable);
    List<Comment> findByResponseToId(Long responseToId);
}
