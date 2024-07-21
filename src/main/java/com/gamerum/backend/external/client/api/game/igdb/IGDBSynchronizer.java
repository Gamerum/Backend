package com.gamerum.backend.external.client.api.game.igdb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamerum.backend.external.client.api.game.GameDbSynchronizer;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GenreDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.GameESRepository;
import com.gamerum.backend.external.persistence.elasticsearch.repository.GenreESRepository;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class IGDBSynchronizer implements GameDbSynchronizer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final int limitPerRequest = 500;

    private final IGDBApi igdbApi;
    private final GameESRepository gameRepository;
    private final GenreESRepository genreRepository;

    public IGDBSynchronizer(IGDBApi igdbApi, GameESRepository gameRepository, GenreESRepository genreRepository) {
        this.igdbApi = igdbApi;
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional
    public void syncData() throws UnirestException, IGDBRequestException, IOException {
        int page = 0;
        boolean moreData = true;

        while (moreData) {
            JsonNode jsonData = igdbApi.getGames(page, limitPerRequest);

            // Parse response into generic Map lists
            List<Map<String, Object>> gamesData = parseResponse(jsonData, true);
            List<Map<String, Object>> genresData = parseResponse(jsonData, false);

            // Convert genre maps to GenreDocument objects
            List<GenreDocument> genres = genresData.stream()
                    .map(this::mapToGenreDocument)
                    .collect(Collectors.toList());

            // Save genres and create a map for quick access
            Map<String, GenreDocument> genreMap = new HashMap<>();
            for (GenreDocument genre : genres) {
                genreRepository.save(genre);
                genreMap.put(genre.getId(), genre);
            }

            // Convert game maps to GameDocument objects and set genres
            List<GameDocument> games = gamesData.stream()
                    .map(gameData -> mapToGameDocument(gameData, genreMap))
                    .collect(Collectors.toList());

            // Save games
            gameRepository.saveAll(games);

            page++;
            moreData = false;
        }
    }

    private List<Map<String, Object>> parseResponse(JsonNode jsonNode, boolean isGame) throws IOException {
        // Determine the type of the list based on isGame flag
        TypeReference<List<Map<String, Object>>> typeReference = new TypeReference<>() {};
        return objectMapper.readValue(jsonNode.toString(), typeReference);
    }

    private GenreDocument mapToGenreDocument(Map<String, Object> genreData) {
        GenreDocument genre = new GenreDocument();
        genre.setId(String.valueOf(genreData.get("id")));
        genre.setName((String) genreData.get("name"));
        return genre;
    }

    private GameDocument mapToGameDocument(Map<String, Object> gameData, Map<String, GenreDocument> genreMap) {
        GameDocument game = new GameDocument();
        game.setId(String.valueOf(gameData.get("id")));
        game.setName((String) gameData.get("name"));

        if (gameData.containsKey("genres")) {
            List<Map<String, Object>> genres = (List<Map<String, Object>>) gameData.get("genres");
            List<GenreDocument> gameGenres = genres.stream()
                    .map(genreData -> genreMap.get(String.valueOf(genreData.get("id"))))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            game.setGenres(gameGenres);
        }

        return game;
    }
}
