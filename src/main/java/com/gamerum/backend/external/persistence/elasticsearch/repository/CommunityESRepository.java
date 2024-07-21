package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommunityESRepository extends ElasticsearchRepository<CommunityDocument, String> {
    Page<CommunityDocument> findByGameId(String gameId, Pageable pageable);
}
