package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "community")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class CommunityDocument implements DocumentBase {
    @Id
    private String id;
    private String title;
    private String description;
    private Long memberCount;
    private Long clickCount;
    private GameDocument game;

    @Override
    public String getIndex() {
        return "community";
    }
}
