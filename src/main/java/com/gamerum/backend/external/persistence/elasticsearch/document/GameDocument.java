package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.stream.Collectors;

@Document(indexName = "game")
@Data
@AllArgsConstructor
public class GameDocument {
    @Id
    private String id;
    private String name;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<String> genres;

    // Factory method for JSON deserialization
    @JsonCreator
    public static GameDocument fromJson(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("genres") List<Genre> genres) {
        List<String> genreNames = genres == null ? null : genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
        return new GameDocument(id, name, genreNames);
    }

    @Data
    public static class Genre {
        private long id;
        private String name;
    }
}
