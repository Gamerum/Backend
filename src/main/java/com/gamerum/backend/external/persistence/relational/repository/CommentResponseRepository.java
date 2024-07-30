package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.CommentResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentResponseRepository extends JpaRepository<CommentResponse, Long> {
    List<CommentResponse> findByCommentId(Long commentId, Pageable pageable);
}
