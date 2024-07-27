package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


@EqualsAndHashCode(callSuper = true)
@Document(indexName = "community")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDocument extends DocumentBase {
    @Id
    private String id;
    private String title;
    private String description;
    private String gameId;

    public CommunityDocument(Community community) {
        id = community.getId().toString();
        title = community.getTitle();
        description = community.getDescription();
        gameId = community.getGameId();
    }

    @Override
    public String getIndex() {
        return "community";
    }
}
