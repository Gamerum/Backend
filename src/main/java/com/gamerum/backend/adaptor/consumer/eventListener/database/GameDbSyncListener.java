package com.gamerum.backend.adaptor.consumer.eventListener.database;

import com.gamerum.backend.external.client.api.game.GameDbSynchronizer;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class GameDbSyncListener {
    private final GameDbSynchronizer synchronizer;

    @PostConstruct
    @Scheduled(fixedRate = 86400000) // Run once a day
    public void runSyncJob() throws UnirestException, IOException, IGDBRequestException {
        synchronizer.syncData();
    }
}
