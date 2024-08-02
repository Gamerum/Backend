package com.gamerum.backend.usecase.service.sync;

import com.gamerum.backend.external.client.api.igdb.IGDBClient;
import com.gamerum.backend.external.client.api.igdb.query.IGDBDefaultQueries;
import com.gamerum.backend.external.client.api.Token;
import com.gamerum.backend.external.client.api.twitch.TwitchClient;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.file.FileRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IGDBSynchronizer {
    private final IGDBClient igdbClient;
    private final TwitchClient twitchClient;
    private final FileRepository fileRepository;
    private final ElasticsearchRepository elasticsearchRepository;

    private final String logFilePath = "sync_games_log.txt";

    private Token token;

    @Value("${api.twitch.client_id}")
    private String clientId;

    @Value("${api.twitch.client_secret}")
    private String clientSecret;

    @Value("${api.twitch.grant_type}")
    private String grantType;


    public IGDBSynchronizer(IGDBClient igdbClient, TwitchClient twitchClient, FileRepository fileRepository, ElasticsearchRepository elasticsearchRepository) {
        this.igdbClient = igdbClient;
        this.twitchClient = twitchClient;
        this.fileRepository = fileRepository;
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostConstruct
    public void init() {
        token = twitchClient.getToken(clientId, clientSecret, grantType);
    }

    public void syncGames() throws IOException {
        if (token.isExpired())
            token = twitchClient.getToken(clientId, clientSecret, grantType);

        elasticsearchRepository.deleteIndex("game");

       // elasticsearchRepository.deleteIndex("community");

        String date = getLastSyncDate();
        int page = 0;

        String query = IGDBDefaultQueries.getGamesQuery(page++, 500, date);
        List<GameDocument> games = igdbClient.getGames(
                clientId,
                token.getAuthorization(),
                "igdb-api-jvm",
                query);

        if (games.isEmpty()) return;
        elasticsearchRepository.saveAll(games);

        //saveLastSyncDate();
    }

    private String getLastSyncDate() {
        try {
            return fileRepository.readFileFromExternalDirectory(logFilePath);
        } catch (IOException e) {
            return "0";
        }
    }

    private void saveLastSyncDate() throws IOException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        fileRepository.writeFileToExternalDirectory(logFilePath, String.valueOf(currentTimestamp));
    }
}
