package com.gamerum.backend.adaptor.dto.community.post.comment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseUpdateDTO {
    private Long id;
    private String text;
}

