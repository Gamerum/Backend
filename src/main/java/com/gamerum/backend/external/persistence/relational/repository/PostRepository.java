package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
    Optional<Post> findByIdAndCommunityId(Long id, Long communityId);
    List<Post> findByTag(String tag);
    List<Post> findByCommunityId(Long id);
    List<Post> findByProfileId(Long id);

}
