package com.gamerum.backend.usecase.service.popular;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;

import java.io.IOException;
import java.util.List;

public interface PopularService {
    List<CommunityDocument> getPopularCommunities() throws IOException;
    List<PostDocument> getPopularPosts(int page) throws IOException;
    List<PostDocument> getCommunityPopularPosts(String communityId, int page) throws IOException;
}
