package com.gamerum.backend.usecase.service.profile.impl;

import com.gamerum.backend.external.persistence.entity.Profile;
import com.gamerum.backend.external.persistence.repository.ProfileRepository;
import com.gamerum.backend.usecase.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile getProfileById(Long profileId) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if(profile.isEmpty())
            throw new RuntimeException();
        return profile.get();
    }

    @Override
    public Profile createProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getProfileNickName(String nickName) {

        Optional<Profile> profile = Optional.ofNullable(profileRepository.findByNickname(nickName));
        if (profile.isEmpty())
            throw new RuntimeException();
        return profile.get();
    }
}
