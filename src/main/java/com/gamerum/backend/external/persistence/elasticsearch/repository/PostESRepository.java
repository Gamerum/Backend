package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostESRepository extends ElasticsearchRepository<PostDocument, String> {
}
