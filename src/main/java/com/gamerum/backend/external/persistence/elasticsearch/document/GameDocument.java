package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = "game")
@Data
@Builder
@AllArgsConstructor
@JacksonStdImpl
public class GameDocument extends DocumentBase{
    @Id
    private String id;
    private String name;
    private List<String> alternativeNames;
    private List<Integer> genreIds;
    private Double popularity;

    // Factory method for JSON deserialization
    @JsonCreator
    public static GameDocument fromJson(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("alternative_names") List<AlternativeName> alternativeNameEntities,
                                        @JsonProperty("genres") List<GenreEntity> genreEntities,
                                        @JsonProperty("total_rating") Double totalRating,
                                        @JsonProperty("total_rating_count") Integer totalRatingCount) {

        List<String> alternativeNames = alternativeNameEntities == null ? null : alternativeNameEntities.stream()
                .map(AlternativeName::getName)
                .toList();

        List<Integer> genreIds = genreEntities == null ? null : genreEntities.stream()
                .map(GenreEntity::getId)
                .collect(Collectors.toList());

        double popularity = 0.0;
        if (totalRating != null && totalRatingCount != null)
            popularity = totalRating * totalRatingCount;

        return new GameDocument(id, name, alternativeNames, genreIds, popularity);
    }

    @Override
    public String getIndex() {
        return "game";
    }

    @Data
    public static class GenreEntity {
        private int id;
    }

    @Data
    public static class AlternativeName {
        private long id;
        private String name;
    }
}
