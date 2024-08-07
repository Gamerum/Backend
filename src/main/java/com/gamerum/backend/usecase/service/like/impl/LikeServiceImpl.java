package com.gamerum.backend.usecase.service.like.impl;

import com.gamerum.backend.external.persistence.elasticsearch.document.LikeableDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.usecase.service.like.LikeService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final ElasticsearchRepository elasticsearchRepository;
    private final CurrentUser currentUser;

    public LikeServiceImpl(ElasticsearchRepository elasticsearchRepository, CurrentUser currentUser) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.currentUser = currentUser;
    }

    @Override
    public <T extends LikeableDocument> boolean updateLikeCount(String index, String id, Class<T> documentClass) throws IOException {
        T document = elasticsearchRepository.getById(index, id, documentClass);
        boolean isLiked;

        String likerId = currentUser.getProfileId().toString();
        List<String> likerIds = document.getLikedByProfileIds();
        if (likerIds.contains(likerId)) {
            likerIds.remove(likerId);
            isLiked = false;
        } else {
            likerIds.add(likerId);
            isLiked = true;
        }

        document.setLikedByProfileIds(likerIds);
        elasticsearchRepository.save(document);
        return isLiked;
    }
}
