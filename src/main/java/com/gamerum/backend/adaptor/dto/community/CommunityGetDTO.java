package com.gamerum.backend.adaptor.dto.community;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostMetadataDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityGetDTO {
    private Long id;
    private String title;
    private String description;
    @Setter
    private GameDocument game;
    private String tags;
    private List<CommunityMemberGetDTO> members;
    private List<PostMetadataDTO> popularPosts;
}
