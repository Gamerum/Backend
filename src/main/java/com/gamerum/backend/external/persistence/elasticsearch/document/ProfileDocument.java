package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Document(indexName = "profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class ProfileDocument extends DocumentBase{
    @Id
    private String id;
    private String nickname;
    private List<String> communityIds;

    @Override
    public String getIndex() {
        return "profile";
    }
}
