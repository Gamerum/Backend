package com.gamerum.backend.adaptor.dto.community;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostMetadataGetDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class CommunityGetDTO {
    private Long id;
    private String title;
    private String description;
    private GameDocument game;
    private String tags;
    private Set<CommunityMemberGetDTO> members;
    private Set<PostMetadataGetDTO> popularPosts;
}
