package com.gamerum.backend.usecase.service.profile.impl;

import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.gamerum.backend.adaptor.dto.user.profile.ProfileUpdateDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.profile.ProfileService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Value("${page.profile.community_size}")
    private int communitySize;

    @Value("${page.profile.post_size}")
    private int postSize;

    private final ProfileRepository profileRepository;
    private final ElasticsearchRepository elasticsearchRepository;
    private final CurrentUser currentUser;

    public ProfileServiceImpl(ProfileRepository profileRepository, ElasticsearchRepository elasticsearchRepository, CurrentUser currentUser) {
        this.profileRepository = profileRepository;
        this.elasticsearchRepository = elasticsearchRepository;
        this.currentUser = currentUser;
    }

    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElseThrow(() -> new NotFoundException("Profile"));
    }

    public List<CommunityDocument> getCommunities(Long profileId, int page) throws IOException {
        ProfileDocument profileDocument = elasticsearchRepository.getById(
                "profile", profileId.toString(), ProfileDocument.class);

        List<FieldValue> fieldValues = profileDocument.getCommunityIds().stream()
                .skip((long) page * communitySize)
                .limit(communitySize)
                .map(FieldValue::of)
                .collect(Collectors.toList());

        BoolQuery boolQuery = QueryBuilders.bool()
                .must(QueryBuilders.terms()
                        .field("_id")
                        .terms(t -> t.value(fieldValues))
                        .build()._toQuery())
                .build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("community")
                .query(q -> q.bool(boolQuery))
                .build();

        return elasticsearchRepository.search(searchRequest, CommunityDocument.class);
    }

    @Override
    public List<PostDocument> getPosts(Long profileId, int page) throws IOException {
        BoolQuery boolQuery = QueryBuilders.bool()
                .must(QueryBuilders.term()
                        .field("profile.id")
                        .value(profileId.toString())
                        .build()._toQuery())
                .build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("post")
                .query(q -> q.bool(boolQuery))
                .from(page * postSize)
                .size(postSize)
                .sort(s -> s.field(f -> f.field("createdDate").order(SortOrder.Desc)))
                .build();

        return elasticsearchRepository.search(searchRequest, PostDocument.class);
    }

    @Override
    public Profile updateProfile(ProfileUpdateDTO profileUpdateDTO) {
        Profile profile = profileRepository.findById(profileUpdateDTO.getId()).
                orElseThrow(() -> new NotFoundException("Profile"));

        if (!currentUser.getProfileId().equals(profile.getId()))
            throw new NotAllowedException();

        profile.setNickname(profileUpdateDTO.getNickname());
        return profileRepository.save(profile);
    }
}