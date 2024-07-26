package com.gamerum.backend.usecase.service.search.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.transport.TransportOptions;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final GameESRepository gameRepository;
    private final CommunityESRepository communityRepository;
    private final ProfileESRepository profileRepository;
    private final PostESRepository postRepository;

    private final ElasticsearchClient elasticsearchClient;


    @Override
    public List<GameDocument> searchGame(GameSearchFilter filter) throws IOException {
        // Create a bool query builder
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            // Fuzzy query on the name field
            Query fuzzyQuery = QueryBuilders.fuzzy()
                    .field("name")
                    .value(filter.getKeyword())
                    .fuzziness("1")
                    .build()._toQuery();

            // Add the fuzzy query to the must clause
            boolQueryBuilder.must(fuzzyQuery);
        }

        // Conditionally add the terms query based on the presence of genreIds
        if (filter.getGenreIds() != null && !filter.getGenreIds().isEmpty()) {
            for (Integer genreId : filter.getGenreIds()) {
                Query termQuery = QueryBuilders.term()
                        .field("genreIds")
                        .value(genreId)
                        .build()._toQuery();
                boolQueryBuilder.must(termQuery);
            }
        }

        // Build the bool query
        BoolQuery boolQuery = boolQueryBuilder.build();

        // Create the search request
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("game")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("_score").order(SortOrder.Desc)))
                .from(filter.getPage() * filter.getSize())
                .size(filter.getSize())
                .build();

        // Execute the search
        SearchResponse<GameDocument> searchResponse = elasticsearchClient.search(searchRequest, GameDocument.class);

        // Extract and return the results
        List<GameDocument> results = searchResponse.hits().hits().stream()
                .map(Hit::source)
                .toList();

        return results;
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
