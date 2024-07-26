package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = "game")
@Data
@AllArgsConstructor
public class GameDocument extends DocumentBase{
    @Id
    private String id;
    private String name;
    private List<Integer> genreIds;

    // Factory method for JSON deserialization
    @JsonCreator
    public static GameDocument fromJson(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("genres") List<GenreEntity> genreEntities) {
        List<Integer> genreIds = genreEntities == null ? null : genreEntities.stream()
                .map(GenreEntity::getId)
                .collect(Collectors.toList());
        return new GameDocument(id, name, genreIds);
    }

    @Override
    public String getIndex() {
        return "game";
    }

    @Data
    public static class GenreEntity {
        private int id;
    }
}
