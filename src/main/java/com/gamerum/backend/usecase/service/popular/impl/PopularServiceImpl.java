package com.gamerum.backend.usecase.service.popular.impl;

import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.usecase.service.popular.PopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PopularServiceImpl implements PopularService {
    @Value("${page.community.top_popular_size}")
    private int communityTopPopularSize;

    @Value("${page.post.popular_size}")
    private int postPopularSize;

    @Value("${page.community.post_size}")
    private int communityPostSize;

    @Autowired
    private ElasticsearchRepository repository;

    @Override
    public List<CommunityDocument> getPopularCommunities() throws IOException {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("community")
                .sort(s -> s.field(f -> f.field("clickCount").order(SortOrder.Desc)))
                .size(communityTopPopularSize)
                .build();

        return repository.search(searchRequest, CommunityDocument.class);
    }

    @Override
    public List<PostDocument> getPopularPosts(int page) throws IOException {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("post")
                .sort(s -> s.field(f -> f.field("createdDate").order(SortOrder.Desc)))
                .sort(s -> s.field(f -> f.field("clickCount").order(SortOrder.Desc)))
                .from(page * postPopularSize)
                .size(postPopularSize)
                .build();

        return repository.search(searchRequest, PostDocument.class);
    }

    @Override
    public List<PostDocument> getCommunityPopularPosts(String communityId, int page) throws IOException {
        BoolQuery.Builder boolQueryBuilder = QueryBuilders.bool();

        Query wildcardQuery = QueryBuilders.term()
                .field("community.id")
                .value(communityId)
                .build()._toQuery();

        boolQueryBuilder.must(wildcardQuery);

        BoolQuery boolQuery = boolQueryBuilder.build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("post")
                .query(q -> q.bool(boolQuery))
                .sort(s -> s.field(f -> f.field("createdDate").order(SortOrder.Desc)))
                .sort(s -> s.field(f -> f.field("clickCount").order(SortOrder.Desc)))
                .from(page * communityPostSize)
                .size(communityPostSize)
                .build();

        return repository.search(searchRequest, PostDocument.class);
    }

}
