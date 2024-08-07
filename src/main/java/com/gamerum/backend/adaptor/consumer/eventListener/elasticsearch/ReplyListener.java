package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.ReplyDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Reply;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

import java.io.IOException;
import java.util.ArrayList;

public class ReplyListener {

    private final ElasticsearchRepository elasticsearchRepository;

    public ReplyListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }


    @PostPersist
    public void handleAfterSave(Reply reply) throws IOException {
        elasticsearchRepository.save(ReplyDocument.builder()
                .id(reply.getId().toString())
                .likedByProfileIds(new ArrayList<>())
                .build());
    }

    @PostRemove
    public void handleAfterUpdate(Reply reply) throws IOException {
        elasticsearchRepository.deleteById(reply.getId().toString(), "reply");
    }
}
