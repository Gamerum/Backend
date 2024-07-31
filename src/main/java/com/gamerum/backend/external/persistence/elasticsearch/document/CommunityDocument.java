package com.gamerum.backend.external.persistence.elasticsearch.document;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@EqualsAndHashCode(callSuper = true)
@Document(indexName = "community")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDocument extends DocumentBase {
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
