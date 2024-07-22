package com.gamerum.backend.external.persistence.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDocument {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;
}
