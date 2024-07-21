package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends CrudRepository<Community, Long> {
    Community findByTitle(String name);
    List<Community> findAllByOrderByClickCountDesc(Pageable pageable);
}
