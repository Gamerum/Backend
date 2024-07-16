package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.Community;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends CrudRepository<Community, Long> {
    Community findByTitle(String name);
}
