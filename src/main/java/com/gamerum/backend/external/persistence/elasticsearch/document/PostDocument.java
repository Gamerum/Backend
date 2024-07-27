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
    private CommunityDocument community;

    public PostDocument(Post post, CommunityDocument communityDocument) {
        id = post.getId().toString();
        title = post.getTitle();
        text = post.getText();
        community = communityDocument;
    }

    @Override
    public String getIndex() {
        return "post";
    }
}
