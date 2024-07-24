package com.gamerum.backend.adaptor.dto.community.post.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateDTO {
    private String text;
    private Long respondCommentId;
    private Long postId;
    private Long writerProfileId;
}
