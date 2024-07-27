package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


@EqualsAndHashCode(callSuper = true)
@Document(indexName = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDocument extends DocumentBase{
    @Id
    private String id;
    private String nickname;

    public ProfileDocument(Profile profile) {
        id = profile.getId().toString();
        nickname = profile.getNickname();
    }

    @Override
    public String getIndex() {
        return "profile";
    }
}
