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
              "query": {
                "bool": {
                  "must": [
                    {
                      "fuzzy": {
                        "name": {
                          "value": "?0",
                          "fuzziness": "AUTO",
                          "prefix_length": 2
                        }
                      }
                    }
                  ],
                  "filter": [
                    {
                      "terms": {
                        "genreIds": ?1
                      }
                    }
                  ]
                }
              },
              "sort": [
                {
                  "_score": {
                    "order": "desc"
                  }
                }
              ]
            }
            """)
    Page<GameDocument> searchByNameAndGenres(String name, List<Integer> genreIds, Pageable pageable);
}
