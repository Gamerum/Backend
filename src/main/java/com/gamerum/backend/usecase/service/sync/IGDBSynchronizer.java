package com.gamerum.backend.usecase.service.sync;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import com.gamerum.backend.external.client.api.igdb.IGDBClient;
import com.gamerum.backend.external.client.api.igdb.query.IGDBDefaultQueries;
import com.gamerum.backend.external.client.api.Token;
import com.gamerum.backend.external.client.api.twitch.TwitchClient;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.GameESRepository;
import com.gamerum.backend.external.persistence.file.FileRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IGDBSynchronizer {
    private final IGDBClient igdbClient;
    private final TwitchClient twitchClient;
    private final FileRepository fileRepository;
    private final ElasticsearchClient elasticsearchClient;

    private final String logFilePath = "sync_games_log.txt";

    private Token token;

    @Value("${api.twitch.client_id}")
    private String clientId;

    @Value("${api.twitch.client_secret}")
    private String clientSecret;

    @Value("${api.twitch.grant_type}")
    private String grantType;


    public IGDBSynchronizer(IGDBClient igdbClient, TwitchClient twitchClient, FileRepository fileRepository, ElasticsearchClient elasticsearchClient) {
        this.igdbClient = igdbClient;
        this.twitchClient = twitchClient;
        this.fileRepository = fileRepository;
        this.elasticsearchClient = elasticsearchClient;
    }

    @PostConstruct
    public void init() {
        token = twitchClient.getToken(clientId, clientSecret, grantType);
    }

    public void syncGames() throws IOException {
        if (token.isExpired())
            token = twitchClient.getToken(clientId, clientSecret, grantType);

        deleteAllGames();

        String date = getLastSyncDate();
        int page = 0;

        String query = IGDBDefaultQueries.getGamesQuery(page++, 500, date);
        List<GameDocument> games = igdbClient.getGames(
                clientId,
                token.getAuthorization(),
                "igdb-api-jvm",
                query);

        if (games.isEmpty()) return;
        saveGames(games);

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

    private void saveGames(List<GameDocument> games) throws IOException {
        List<BulkOperation> operations = games.stream()
                .map(gameDocument -> BulkOperation.of(b -> b
                        .index(i -> i
                                .index("game")
                                .id(gameDocument.getId())
                                .document(gameDocument)
                        )
                ))
                .collect(Collectors.toList());

        BulkRequest bulkRequest = BulkRequest.of(b -> b
                .operations(operations)
        );

        elasticsearchClient.bulk(bulkRequest);
    }

    private void deleteAllGames() throws IOException {
        // Create a query to match all documents
        Query query = QueryBuilders.matchAll().build()._toQuery();

        // Create a DeleteByQueryRequest with the query
        DeleteByQueryRequest deleteByQueryRequest = DeleteByQueryRequest.of(d -> d
                .index("game") // Specify the index name
                .query(query)     // Use match_all query to delete all documents
        );

        // Execute the delete by query request
        DeleteByQueryResponse deleteByQueryResponse = elasticsearchClient.deleteByQuery(deleteByQueryRequest);

        // Check the response
        System.out.println("Deleted documents count: " + deleteByQueryResponse.deleted());

    }
}
