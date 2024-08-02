package com.gamerum.backend.usecase.service.search.impl;

import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.gamerum.backend.adaptor.dto.search.CommunitySearchFilter;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.adaptor.dto.search.PostSearchFilter;
import com.gamerum.backend.adaptor.dto.search.SearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.usecase.service.search.SearchService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private final ElasticsearchRepository repository;

    public SearchServiceImpl(ElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GameDocument> searchGame(GameSearchFilter filter) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            Query wildcardQuery = QueryBuilders.wildcard()
                    .field("name")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            Query termsQuery = QueryBuilders.wildcard()
                    .field("alternativeNames")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            boolQueryBuilder.should(wildcardQuery);
            boolQueryBuilder.should(termsQuery);
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

        return repository.search(searchRequest, GameDocument.class);
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

        return repository.search(searchRequest, CommunityDocument.class);
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

        return repository.search(searchRequest, ProfileDocument.class);
    }

    @Override
    public List<PostDocument> searchPost(PostSearchFilter filter) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            Query wildcardQuery = QueryBuilders.wildcard()
                    .field("title")
                    .value(filter.getKeyword() + "*")
                    .build()._toQuery();

            boolQueryBuilder.must(wildcardQuery);
        }

        if (filter.getCommunityId() != null && filter.getCommunityId().equals("0")) {
            Query termQuery = QueryBuilders.term()
                    .field("community.id")
                    .value(filter.getCommunityId())
                    .build()._toQuery();
            boolQueryBuilder.must(termQuery);

            if (filter.getTag() != null && filter.getTag().isBlank()) {
                Query tagQuery = QueryBuilders.term()
                        .field("tag")
                        .value(filter.getTag())
                        .build()._toQuery();
                boolQueryBuilder.must(tagQuery);
            }
        }

        BoolQuery boolQuery = boolQueryBuilder.build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("post")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("createdDate").order(SortOrder.Desc)))
                .sort(s -> s.field(f -> f.field("clickCount").order(SortOrder.Desc)))
                .sort(s -> s.field(f -> f.field("_score").order(SortOrder.Desc)))
                .from(filter.getPage() * filter.getSize())
                .size(filter.getSize())
                .build();

        return repository.search(searchRequest, PostDocument.class);
    }
}
