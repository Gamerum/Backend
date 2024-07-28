package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.AlreadyParticipatedException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommunityMemberServiceImpl implements CommunityMemberService {

    @Autowired
    private CommunityMemberRepository communityMemberRepository;

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public CommunityMember createCommunityMember(Long communityId, CommunityMemberCreateDTO communityMemberCreateDTO) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile newMemberProfile = profileRepository.findById(communityMemberCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(newMemberProfile.getId(), community.getId()))
            throw new AlreadyParticipatedException(newMemberProfile.getNickname());

        if (newMemberProfile.getId() != communityMemberCreateDTO.getJoinedByProfileId() &&
                !profileRepository.existsById(communityMemberCreateDTO.getJoinedByProfileId()))
            throw new NotFoundException("Adder");

        CommunityMember newMember = CommunityMember.builder()
                .profile(newMemberProfile)
                .community(community)
                .role(CommunityMember.Role.USER)
                .build();

        return communityMemberRepository.save(newMember);
    }

    @Override
    public List<CommunityMember> getCommunityMembers(Long communityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return communityMemberRepository.findByCommunityId(communityId, pageable);
    }

    @Override
    public void deleteCommunityMember(Long communityId, Long communityMemberId) {
        if (jwtUtil.currentUserHasRole(UserRole.ROLE_ADMIN)) {
            communityMemberRepository.deleteById(communityMemberId);
            return;
        }

        CommunityMember deleter = communityMemberRepository
                .findByProfileIdAndCommunityId(jwtUtil.getCurrentUserProfileId(), communityId)
                .orElseThrow(NotParticipatedException::new);

        if (Objects.equals(deleter.getId(), communityMemberId)) {
            communityMemberRepository.delete(deleter);
            return;
        }

        if (deleter.getRole() == CommunityMember.Role.USER)
            throw new NotAllowedException();

        communityMemberRepository.deleteById(communityMemberId);
    }
}
