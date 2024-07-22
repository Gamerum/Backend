package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GameESRepository extends ElasticsearchRepository<GameDocument, String> {
    @Query("{\"fuzzy\": { \"name\": { \"value\": \"?0\" } }}")
    List<GameDocument> findByNicknameFuzzy(String searchTerm, Pageable pageable);
}
