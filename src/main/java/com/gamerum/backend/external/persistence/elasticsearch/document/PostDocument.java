package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class PostDocument extends DocumentBase {
    @Id
    private String id;
    private String title;
    private String text;
    private Long clickCount;
    private ProfileDocument profile;
    private CommunityDocument community;
    private Date createdDate;

    @Override
    public String getIndex() {
        return "post";
    }
}
