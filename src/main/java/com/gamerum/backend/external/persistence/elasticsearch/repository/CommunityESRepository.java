package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CommunityESRepository extends ElasticsearchRepository<CommunityDocument, String> {
    List<CommunityDocument> findByGameId(String searchTerm, Pageable pageable);
}
