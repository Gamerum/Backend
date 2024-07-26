package com.gamerum.backend.usecase.service.search.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.gamerum.backend.adaptor.dto.search.CommunitySearchFilter;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.adaptor.dto.search.SearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.usecase.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final ElasticsearchClient elasticsearchClient;


    @Override
    public List<GameDocument> searchGame(GameSearchFilter filter) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            Query wildcardQuery = QueryBuilders.wildcard()
                    .field("name")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            boolQueryBuilder.must(wildcardQuery);
        }

        if (filter.getGenreIds() != null && !filter.getGenreIds().isEmpty()) {
            for (Integer genreId : filter.getGenreIds()) {
                Query termQuery = QueryBuilders.term()
                        .field("genreIds")
                        .value(genreId)
                        .build()._toQuery();
                boolQueryBuilder.must(termQuery);
            }
        }

        BoolQuery boolQuery = boolQueryBuilder.build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("game")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("_score").order(SortOrder.Desc)))
                .from(filter.getPage() * filter.getSize())
                .size(filter.getSize())
                .build();

        SearchResponse<GameDocument> searchResponse = elasticsearchClient.search(searchRequest, GameDocument.class);

        List<GameDocument> results = searchResponse.hits().hits().stream()
                .map(Hit::source)
                .toList();

        return results;
    }

    @Override
    public List<CommunityDocument> searchCommunity(CommunitySearchFilter filter) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            Query wildcardQuery = QueryBuilders.wildcard()
                    .field("title")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            boolQueryBuilder.must(wildcardQuery);
        }

        if (filter.getGameId() != null && !filter.getGameId().isEmpty()) {
                Query termQuery = QueryBuilders.term()
                        .field("gameId")
                        .value(filter.getGameId())
                        .build()._toQuery();
                boolQueryBuilder.must(termQuery);
        }

        BoolQuery boolQuery = boolQueryBuilder.build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("community")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("_score").order(SortOrder.Desc)))
                .from(filter.getPage() * filter.getSize())
                .size(filter.getSize())
                .build();

        SearchResponse<CommunityDocument> searchResponse = elasticsearchClient.search(searchRequest, CommunityDocument.class);

        return searchResponse.hits().hits().stream()
                .map(Hit::source)
                .toList();
   }

    @Override
    public List<ProfileDocument> searchProfile(SearchFilter filter) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            Query wildcardQuery = QueryBuilders.wildcard()
                    .field("nickname")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            boolQueryBuilder.must(wildcardQuery);
        }

        BoolQuery boolQuery = boolQueryBuilder.build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("profile")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("_score").order(SortOrder.Desc)))
                .from(filter.getPage() * filter.getSize())
                .size(filter.getSize())
                .build();

        SearchResponse<ProfileDocument> searchResponse = elasticsearchClient.search(searchRequest, ProfileDocument.class);

        return searchResponse.hits().hits().stream()
                .map(Hit::source)
                .toList();
    }

//    @Override
//    public Page<PostDocument> searchPost(SearchFilter filter) {
//        Pageable pageable = PageRequest.of(page, size);
//        return postRepository.findByTitleOrTextContaining(searchTerm, pageable);
//    }
}
