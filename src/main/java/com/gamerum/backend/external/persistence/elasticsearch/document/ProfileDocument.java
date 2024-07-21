package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "profile")
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDocument {
    @Id
    private String id;
    private String nickname;

    public ProfileDocument(Profile profile) {
        id = profile.getId().toString();
        nickname = profile.getNickname();
    }
}
