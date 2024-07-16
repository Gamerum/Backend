package com.gamerum.backend.repository;

import com.gamerum.backend.entity.Community;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends CrudRepository<Community, Long> {
    Community findByTitle(String name);
}
