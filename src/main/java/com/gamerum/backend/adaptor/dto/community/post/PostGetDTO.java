package com.gamerum.backend.adaptor.dto.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class PostGetDTO {
    private Long id;
    private String title;
    private String tag;
    private String text;
    private String writerId;
    private String writerNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long communityId;
    private String communityName;
    private List<CommentGetDTO> comments;
}
