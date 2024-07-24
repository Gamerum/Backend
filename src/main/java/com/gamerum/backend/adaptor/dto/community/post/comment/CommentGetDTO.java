package com.gamerum.backend.adaptor.dto.community.post.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CommentGetDTO {
    private Long id;
    private String text;
    private Long responsedCommentId;
    private Set<CommentGetDTO> responses;
    private Long writerId;
    private String writerNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
