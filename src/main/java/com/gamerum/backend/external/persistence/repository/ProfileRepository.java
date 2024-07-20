package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findByNickname(String name);
}
