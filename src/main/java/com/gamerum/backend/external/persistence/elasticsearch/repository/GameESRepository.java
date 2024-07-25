package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GameESRepository extends ElasticsearchRepository<GameDocument, String> {
    @Query("""
        {
          "bool": {
            "must": [
              {
                "fuzzy": {
                  "name": {
                    "value": "?0"  // This will be replaced by the first method parameter
                  }
                }
              }
            ],
            "filter": [
              {
                "term": {
                  "genre": "?1"  // This will be replaced by the second method parameter
                }
              }
            ]
          }
        }
        """)
    Page<GameDocument> findByNicknameFuzzy(String keyword, List<GameDocument.Genre> genre, Pageable pageable);
}
