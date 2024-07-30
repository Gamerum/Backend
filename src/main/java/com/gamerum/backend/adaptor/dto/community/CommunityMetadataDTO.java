package com.gamerum.backend.adaptor.dto.community;

import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CommunityMetadataDTO {
    private Long id;
    private String title;
    private String description;
    private int memberCount;
    private GameDocument game;
}
