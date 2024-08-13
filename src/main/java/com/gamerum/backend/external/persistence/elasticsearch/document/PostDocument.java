package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDocument extends LikeableDocument {
    @Id
    private String id;
    private String title;
    private String text;
    private String tag;
    private Long clickCount;
    private Long commentCount;
    private Profile writer;
    private Community community;
    private Date createdDate;

    @Override
    public String getIndex() {
        return DocumentIndex.POST;
    }

    public record Profile(String id, String nickname) {
    }

    public record Community(String id, String title) {
    }
}
