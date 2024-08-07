package com.gamerum.backend.usecase.service.like;

import com.gamerum.backend.external.persistence.elasticsearch.document.LikeableDocument;

import java.io.IOException;

public interface LikeService {
    <T extends LikeableDocument> boolean updateLikeCount(String index,String id, Class<T> documentClass) throws IOException;
}
