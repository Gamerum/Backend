package com.gamerum.backend.adaptor.dto.user.profile;

import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProfileGetDTO {
    private Long id;
    private String nickname;
    private List<CommunityMetadataDTO> communities;
    private List<PostDocument> posts;
}
