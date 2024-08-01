package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberUpdateDTO;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityMemberServiceImpl implements CommunityMemberService {
    private final CommunityMemberRepository communityMemberRepository;
    private final CommunityRepository communityRepository;
    private final ProfileRepository profileRepository;
    private final CurrentUser currentUser;

    public CommunityMemberServiceImpl(CommunityMemberRepository communityMemberRepository,
                                      CommunityRepository communityRepository,
                                      ProfileRepository profileRepository,
                                      CurrentUser currentUser) {
        this.communityMemberRepository = communityMemberRepository;
        this.communityRepository = communityRepository;
        this.profileRepository = profileRepository;
        this.currentUser = currentUser;
    }

    @Override
    public CommunityMember createCommunityMember(Long communityId, CommunityMemberCreateDTO communityMemberCreateDTO) {
        if (!communityMemberCreateDTO.getProfileId().equals(currentUser.getProfileId()))
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
        return communityMemberRepository.findByCommunityIdOrderByRoleAsc(communityId, PageRequest.of(page, size));
    }

    @Override
    public CommunityMember updateCommunityMember(CommunityMemberUpdateDTO communityMemberUpdateDTO) {
        CommunityMember communityMember = communityMemberRepository.findById(communityMemberUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Member"));

        if (!communityMember.getProfile().getId().equals(currentUser.getProfileId()))
            throw new NotAllowedException();

        communityMember.setRole(communityMemberUpdateDTO.getRole());
        return communityMemberRepository.save(communityMember);
    }

    @Override
    public void deleteCommunityMember(Long communityId, Long profileId) {
        CommunityMember deletingMember = communityMemberRepository
                .findByProfileIdAndCommunityId(profileId, communityId)
                .orElseThrow(NotParticipatedException::new);

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isSelf = deletingMember.getProfile().getId().equals(currentUser.getProfileId());

        if (!isAdmin && !isSelf) {
            CommunityMember deleter = communityMemberRepository
                    .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                    .orElseThrow(NotParticipatedException::new);

            if (deleter.getRole() == CommunityMember.Role.USER) throw new NotAllowedException();
        }
        communityMemberRepository.delete(deletingMember);
    }
}
