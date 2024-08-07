package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;

@EqualsAndHashCode(callSuper = true)
@Document(indexName = "reply")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class ReplyDocument extends LikeableDocument {
    @Id
    private String id;

    @Override
    public String getIndex() {
        return "reply";
    }
}