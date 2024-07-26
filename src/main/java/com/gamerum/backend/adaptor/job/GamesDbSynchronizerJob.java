package com.gamerum.backend.adaptor.job;

import com.gamerum.backend.usecase.service.sync.IGDBSynchronizer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GamesDbSynchronizerJob {
    private final IGDBSynchronizer synchronizer;

    public GamesDbSynchronizerJob(IGDBSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    //@PostConstruct
    public void runSyncJob() throws IOException {
        synchronizer.syncGames();
    }
}
