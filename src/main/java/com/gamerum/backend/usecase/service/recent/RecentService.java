package com.gamerum.backend.usecase.service.recent;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;

import java.io.IOException;

public interface RecentService {
    void saveLastViewedPostToCurrentProfile(PostDocument postDocument) throws IOException;
    void saveLastViewedCommunityToCurrentProfile(CommunityDocument communityDocument) throws IOException;
}
