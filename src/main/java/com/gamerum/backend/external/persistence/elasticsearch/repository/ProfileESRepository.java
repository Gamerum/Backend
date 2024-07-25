package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProfileESRepository extends ElasticsearchRepository<ProfileDocument, String> {
    @Query("{\"fuzzy\": { \"nickname\": { \"value\": \"?0\" } }}")
    Page<ProfileDocument> findByNicknameFuzzy(String searchTerm, Pageable pageable);
}
