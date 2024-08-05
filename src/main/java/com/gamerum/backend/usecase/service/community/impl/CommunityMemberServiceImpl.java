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
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.ParticipationException;
import com.gamerum.backend.usecase.exception.ForbiddenException;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityMemberServiceImpl implements CommunityMemberService {

    @Value("${page.community_member.size}")
    private int memberPageSize;

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
            throw new ForbiddenException();

        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException(Community.class));

        Profile newMemberProfile = profileRepository.findById(communityMemberCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class));

        if (communityMemberRepository.existsByProfileIdAndCommunityId(newMemberProfile.getId(), community.getId()))
            throw new ParticipationException(true);

        CommunityMember newMember = CommunityMember.builder()
                .profile(newMemberProfile)
                .community(community)
                .role(CommunityMember.Role.USER)
                .build();

        return communityMemberRepository.save(newMember);
    }

    @Override
    public List<CommunityMember> getCommunityMembers(Long communityId, int page) {
        return communityMemberRepository.findByCommunityIdOrderByRoleAsc(communityId, PageRequest.of(page, memberPageSize));
    }

    @Override
    public CommunityMember updateCommunityMember(Long communityId, Long profileId, CommunityMemberUpdateDTO communityMemberUpdateDTO) {
        CommunityMember updater = communityMemberRepository
                .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                .orElseThrow(() -> new ParticipationException(false));

        if (updater.getRole().equals(CommunityMember.Role.USER))
            throw new ForbiddenException();

        CommunityMember updatingMember = currentUser.getProfileId().equals(profileId) ? updater :
                communityMemberRepository.findByProfileIdAndCommunityId(profileId, communityId)
                        .orElseThrow(() -> new ParticipationException(false));

        updatingMember.setRole(communityMemberUpdateDTO.getRole());
        return communityMemberRepository.save(updatingMember);
    }

    @Override
    public void deleteCommunityMember(Long communityId, Long profileId) {
        CommunityMember deletingMember = communityMemberRepository
                .findByProfileIdAndCommunityId(profileId, communityId)
                .orElseThrow(() -> new ParticipationException(false));

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isSelf = deletingMember.getProfile().getId().equals(currentUser.getProfileId());

        if (!isAdmin && !isSelf) {
            CommunityMember deleter = communityMemberRepository
                    .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                    .orElseThrow(() -> new ParticipationException(false));

            if (deleter.getRole() == CommunityMember.Role.USER) throw new ForbiddenException();
        }
        communityMemberRepository.delete(deletingMember);
    }
}
