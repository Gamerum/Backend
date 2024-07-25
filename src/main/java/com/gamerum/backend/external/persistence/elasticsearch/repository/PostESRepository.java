package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PostESRepository extends ElasticsearchRepository<PostDocument, String> {
    @Query("{\"bool\": {\"should\": [" +
            "{\"wildcard\": {\"title\": \"*?0*\"}}," +
            "{\"wildcard\": {\"text\": \"*?0*\"}}" +
            "]}}")
    Page<PostDocument> findByTitleOrTextContaining(String searchTerm, Pageable pageable);
}
