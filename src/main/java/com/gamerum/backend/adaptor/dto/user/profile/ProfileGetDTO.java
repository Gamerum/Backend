package com.gamerum.backend.adaptor.dto.user.profile;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProfileGetDTO {
    private Long id;
    private String nickname;
    @Setter
    private List<CommunityDocument> firstPageCommunities;
    @Setter
    private List<PostDocument>  firstPagePosts;
}
