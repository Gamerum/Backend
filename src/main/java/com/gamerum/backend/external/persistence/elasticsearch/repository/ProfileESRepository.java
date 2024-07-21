package com.gamerum.backend.external.persistence.elasticsearch.repository;

import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProfileESRepository extends ElasticsearchRepository<ProfileDocument, String> {
}
