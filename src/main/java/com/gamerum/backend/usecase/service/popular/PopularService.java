package com.gamerum.backend.usecase.service.popular;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;

import java.io.IOException;
import java.util.List;

public interface PopularService {
    List<CommunityDocument> getPopularCommunities() throws IOException;
}
