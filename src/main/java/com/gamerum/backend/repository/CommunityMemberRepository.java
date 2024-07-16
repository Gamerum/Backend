package com.gamerum.backend.repository;

import com.gamerum.backend.entity.CommunityMember;
import com.gamerum.backend.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMemberRepository extends CrudRepository<CommunityMember, Long> {
    List<CommunityMember> findByProfileId(@Param("profile_id") Long profileID);
    List<CommunityMember> findByCommunityId(@Param("community_id") Long profileID);
}
