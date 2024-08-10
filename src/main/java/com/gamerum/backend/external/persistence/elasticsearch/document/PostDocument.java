package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = DocumentIndex.POST)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class PostDocument extends LikeableDocument {
    @Id
    private String id;
    private String title;
    private String text;
    private String tag;
    private Long clickCount;
    private Long commentCount;
    private ProfileDocument writer;
    private CommunityDocument community;
    private Date createdDate;

    @Override
    public String getIndex() {
        return DocumentIndex.POST;
    }
}
