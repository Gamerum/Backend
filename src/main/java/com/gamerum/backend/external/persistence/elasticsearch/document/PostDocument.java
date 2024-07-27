package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDocument extends DocumentBase{
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

    @Override
    public String getIndex() {
        return "post";
    }
}
