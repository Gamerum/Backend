package com.gamerum.backend.external.client.api.igdb.query;

public class IGDBDefaultQueries {
    public static String getGamesQuery(int page, int size, String lastSyncDateTime) {

        return IGDBQueryBuilder.builder()
                .fields("id, name, genres.name")
                .limit(size)
                .offset(page * size)
                .where("parent_game = null " +
                        "& version_parent = null " +
                        "& updated_at > " + lastSyncDateTime)
                .build();
    }
}
