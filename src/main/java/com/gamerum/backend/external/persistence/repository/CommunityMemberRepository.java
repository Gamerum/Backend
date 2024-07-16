package com.gamerum.backend.external.persistence.repository;

import com.gamerum.backend.external.persistence.entity.CommunityMember;
import com.gamerum.backend.external.persistence.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMemberRepository extends CrudRepository<CommunityMember, Long> {
    List<CommunityMember> findByProfileId(@Param("profile_id") Long profileID);
    List<CommunityMember> findByCommunityId(@Param("community_id") Long profileID);
}
