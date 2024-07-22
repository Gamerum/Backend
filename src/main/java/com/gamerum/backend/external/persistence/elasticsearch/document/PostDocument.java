package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDocument {
    @Id
    private String id;
    private String title;
    private String text;
    private String communityId;

    public PostDocument(Post post) {
        id = post.getId().toString();
        title = post.getTitle();
        text = post.getText();
        communityId = post.getCommunity().getId().toString();
    }
}
