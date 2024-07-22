package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.GenreDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GenreESRepository extends ElasticsearchRepository<GenreDocument, String> {
}
