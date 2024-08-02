package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Long> {
    Optional<CommunityMember> findByProfileIdAndCommunityId(Long profileID, Long communityID);
    boolean existsByProfileIdAndCommunityId(Long profileID, Long communityID);
    List<CommunityMember> findByCommunityIdOrderByRoleAsc(Long communityID, Pageable pageable);
}
