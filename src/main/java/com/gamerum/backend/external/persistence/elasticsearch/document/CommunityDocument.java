package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = DocumentIndex.COMMUNITY)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunityDocument implements DocumentBase {
    @Id
    private String id;
    private String title;
    private String description;
    private Long memberCount;
    private Long clickCount;
    private Game game;

    @Override
    public String getIndex() {
        return DocumentIndex.COMMUNITY;
    }

    public record Game(String id, String name) {
    }
}
