package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
    List<Post> findByTag(String tag);
    List<Post> findByCommunityId(@Param("community_id")Long id);
    List<Post> findByProfileId(@Param("profile_id")Long id);
}
