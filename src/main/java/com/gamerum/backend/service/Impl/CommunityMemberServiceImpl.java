package com.gamerum.backend.service.Impl;

import com.gamerum.backend.entity.CommunityMember;
import com.gamerum.backend.repository.CommunityMemberRepository;
import com.gamerum.backend.service.CommunityMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityMemberServiceImpl implements CommunityMemberService {

    @Autowired
    private CommunityMemberRepository communityMemberRepository;
    @Override
    public CommunityMember createCommunityMember(CommunityMember communityMember) {
        return communityMemberRepository.save(communityMember);
    }

    @Override
    public CommunityMember getCommunityMember(Long id) {
        Optional<CommunityMember> optional = communityMemberRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException();
        }
        return optional.get();
    }

    @Override
    public List<CommunityMember> getCommunityMembers() {
        return (List<CommunityMember>) communityMemberRepository.findAll();
    }

    @Override
    public void deleteCommunityMember(Long id) {
        communityMemberRepository.deleteById(id);
    }

    @Override
    public List<CommunityMember> getCommunityMembersByCommunity(Long communityId) {
        return communityMemberRepository.findByCommunityId(communityId);
    }

    @Override
    public List<CommunityMember> getCommunityMembersByProfile(Long profileId) {
        return communityMemberRepository.findByProfileId(profileId);
    }
}
