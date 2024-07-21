package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.PostESRepository;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostSyncListener {
    private final PostESRepository postESRepository;

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Post post) {
        PostDocument document = new PostDocument(post);
        postESRepository.save(document);
    }

    @PostRemove
    public void handleAfterDelete(Post post) {
        postESRepository.deleteById(post.getId().toString());
    }
}
