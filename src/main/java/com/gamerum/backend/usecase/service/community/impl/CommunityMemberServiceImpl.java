package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.AlreadyParticipatedException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CurrentUser currentUser;

    @Override
    public CommunityMember createCommunityMember(Long communityId, CommunityMemberCreateDTO communityMemberCreateDTO) {
        if (!Objects.equals(communityMemberCreateDTO.getProfileId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile newMemberProfile = profileRepository.findById(communityMemberCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (communityMemberRepository.existsByProfileIdAndCommunityId(newMemberProfile.getId(), community.getId()))
            throw new AlreadyParticipatedException(newMemberProfile.getNickname());

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
    public void deleteCommunityMember(Long communityId, Long profileId) {
        CommunityMember deletingMember = communityMemberRepository
                .findByProfileIdAndCommunityId(profileId, communityId)
                .orElseThrow(NotParticipatedException::new);

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isSelf = deletingMember.getProfile().getId().equals(currentUser.getProfileId());


        if (isAdmin || isSelf) {
            communityMemberRepository.delete(deletingMember);
            return;
        }

        CommunityMember deleter = communityMemberRepository
                .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                .orElseThrow(NotParticipatedException::new);

        if (deleter.getRole() == CommunityMember.Role.USER)
            throw new NotAllowedException();

        communityMemberRepository.deleteById(profileId);
    }
}
