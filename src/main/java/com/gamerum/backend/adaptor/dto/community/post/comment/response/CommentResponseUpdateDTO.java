package com.gamerum.backend.adaptor.dto.community.post.comment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponseUpdateDTO {
    private Long id;
    private String text;
}

