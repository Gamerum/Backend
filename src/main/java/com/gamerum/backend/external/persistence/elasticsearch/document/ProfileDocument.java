package com.gamerum.backend.external.persistence.elasticsearch.document;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Document(indexName = "profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
