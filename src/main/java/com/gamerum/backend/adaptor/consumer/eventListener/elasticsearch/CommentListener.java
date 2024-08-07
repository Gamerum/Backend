package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommentDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

import java.io.IOException;
import java.util.ArrayList;

public class CommentListener {

    private final ElasticsearchRepository elasticsearchRepository;

    public CommentListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }


    @PostPersist
    public void handleAfterSave(Comment comment) throws IOException {
        elasticsearchRepository.save(CommentDocument.builder()
                .id(comment.getId().toString())
                .likedByProfileIds(new ArrayList<>())
                .build());
    }

    @PostRemove
    public void handleAfterUpdate(Comment comment) throws IOException {
        elasticsearchRepository.deleteById(comment.getId().toString(), "comment");
    }
}
