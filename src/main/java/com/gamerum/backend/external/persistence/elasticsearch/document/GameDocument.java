package com.gamerum.backend.external.persistence.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "game")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDocument {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Nested, index = false)
    private List<GenreDocument> genres;
}
