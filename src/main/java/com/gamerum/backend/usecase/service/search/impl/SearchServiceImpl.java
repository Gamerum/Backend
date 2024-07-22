package com.gamerum.backend.usecase.service.search.impl;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.CommunityESRepository;
import com.gamerum.backend.external.persistence.elasticsearch.repository.GameESRepository;
import com.gamerum.backend.external.persistence.elasticsearch.repository.PostESRepository;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ProfileESRepository;
import com.gamerum.backend.usecase.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final GameESRepository gameRepository;
    private final CommunityESRepository communityRepository;
    private final ProfileESRepository profileRepository;
    private final PostESRepository postRepository;


    @Override
    public List<GameDocument> searchGameWithName(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return gameRepository.findByNicknameFuzzy(searchTerm, pageable);
    }

    @Override
    public String searchGameWithGenres(String searchTerm, int page, int size) {
        return "";
    }

    @Override
    public List<CommunityDocument> searchCommunity(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return communityRepository.findByGameId(searchTerm, pageable);
    }

    @Override
    public List<ProfileDocument> searchProfile(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return profileRepository.findByNicknameFuzzy(searchTerm, pageable);
    }

    @Override
    public List<PostDocument> searchPost(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findByTitleOrTextContaining(searchTerm, pageable);
    }
}
