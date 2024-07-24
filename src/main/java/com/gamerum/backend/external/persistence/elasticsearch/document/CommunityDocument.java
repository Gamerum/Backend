package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "community")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDocument {
    @Id
    private String id;
    private String title;
    private String description;
    private String gameId;

    public CommunityDocument(Community community) {
        id = community.getId().toString();
        title = community.getTitle();
        description = community.getDescription();
        gameId = String.valueOf(community.getGameId());
    }
}
