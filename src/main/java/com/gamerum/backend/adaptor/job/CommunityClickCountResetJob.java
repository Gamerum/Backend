package com.gamerum.backend.adaptor.job;

import com.gamerum.backend.usecase.service.community.CommunityService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommunityClickCountResetJob {
    private final CommunityService communityService;

    public CommunityClickCountResetJob(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostConstruct
    public void runJob() throws IOException {
        communityService.resetCommunitiesClickCount();
    }
}
