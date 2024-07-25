package com.gamerum.backend.usecase.service.search.impl;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.adaptor.dto.search.SearchFilter;
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
import org.springframework.data.domain.Page;
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
    public Page<GameDocument> searchGame(GameSearchFilter filter) {
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());
        return gameRepository.findByNicknameFuzzy(filter.getKeyword(), filter.getGenres(), pageable);
    }

    @Override
    public Iterable<GameDocument> getAllGames() {
        return gameRepository.findAll();
    }

//    @Override
//    public Page<CommunityDocument> searchCommunity(SearchFilter filter) {
//        Pageable pageable = PageRequest.of(page, size);
//        return communityRepository.findByGameId(searchTerm, pageable);
//    }
//
//    @Override
//    public Page<ProfileDocument> searchProfile(SearchFilter filter) {
//        Pageable pageable = PageRequest.of(page, size);
//        return profileRepository.findByNicknameFuzzy(searchTerm, pageable);
//    }
//
//    @Override
//    public Page<PostDocument> searchPost(SearchFilter filter) {
//        Pageable pageable = PageRequest.of(page, size);
//        return postRepository.findByTitleOrTextContaining(searchTerm, pageable);
//    }
}
