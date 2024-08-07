package com.gamerum.backend.adaptor.job;

import com.gamerum.backend.usecase.service.community.CommunityService;
import com.gamerum.backend.usecase.service.community.post.PostService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ClickCountResetJob {
    private final CommunityService communityService;
    private final PostService postService;

    public ClickCountResetJob(CommunityService communityService, PostService postService) {
        this.communityService = communityService;
        this.postService = postService;
    }

    @PostConstruct
    public void runJob() throws IOException {
        communityService.resetCommunitiesClickCount();
        postService.resetPostsClickCounts();
    }
}
