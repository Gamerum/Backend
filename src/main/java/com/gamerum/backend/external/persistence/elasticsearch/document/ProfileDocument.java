package com.gamerum.backend.external.persistence.elasticsearch.document;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
import java.util.Queue;


@Document(indexName = DocumentIndex.PROFILE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
public class ProfileDocument implements DocumentBase{
    @Id
    private String id;
    private String nickname;
    private List<String> joinedCommunityIds;
    private Queue<ViewedCommunity> recentViewedCommunities;
    private Queue<ViewedPost> recentViewedPosts;

    @Override
    public String getIndex() {
        return DocumentIndex.PROFILE;
    }


    @Getter
    public record ViewedCommunity(String id, String title, Long memberCount) {
    }

    @Getter
    public record ViewedPost(String id, String writerNickname, String communityId, String communityTitle,
                             String title, Long commentCount, Long likeCount) {
    }
}
