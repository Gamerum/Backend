package com.gamerum.backend.adaptor.dto.user.profile;

import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostMetadataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ProfileGetDTO {
    private Long id;
    private String nickname;
    private Set<CommunityMetadataDTO> communities;
    private Set<PostMetadataDTO> posts;
}
