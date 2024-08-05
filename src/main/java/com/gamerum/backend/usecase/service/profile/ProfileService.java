package com.gamerum.backend.usecase.service.profile;

import com.gamerum.backend.adaptor.dto.user.profile.ProfileUpdateDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.relational.entity.Profile;

import java.io.IOException;
import java.util.List;

public interface ProfileService {
    Profile getProfileById(Long profileId);
    Profile updateProfile(Long profileId, ProfileUpdateDTO profileUpdateDTO);
    List<CommunityDocument> getCommunities(Long profileId, int page) throws IOException;
    List<PostDocument> getPosts(Long profileId, int page) throws IOException;
}
