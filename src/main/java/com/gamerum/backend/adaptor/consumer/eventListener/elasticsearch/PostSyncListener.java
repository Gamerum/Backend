package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PostSyncListener {
    private final ElasticsearchClient elasticsearchClient;

    public PostSyncListener(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Post post) throws IOException {
        PostDocument document = new PostDocument(post);
        IndexRequest<PostDocument> indexRequest = IndexRequest.of(i -> i
                .index("post")
                .id(document.getId())
                .document(document));

        elasticsearchClient.index(indexRequest);
    }

    @PostRemove
    public void handleAfterDelete(Post post) throws IOException {
        DeleteRequest deleteRequest = DeleteRequest.of(d -> d
                .index("post")
                .id(String.valueOf(post.getId()))
        );

        elasticsearchClient.delete(deleteRequest);
    }
}
