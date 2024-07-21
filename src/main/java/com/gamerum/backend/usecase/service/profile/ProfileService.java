package com.gamerum.backend.usecase.service.profile;

import com.gamerum.backend.external.persistence.relational.entity.Profile;

public interface ProfileService {
    Profile getProfileById(Long id);
    Profile createProfile(Profile profile);
    Profile updateProfile(Profile profile);
    void deleteProfile(Long id);
    Profile getProfileNickName(String nickName);
}
