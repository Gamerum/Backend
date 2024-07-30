package com.gamerum.backend.adaptor.dto.community.post.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentUpdateDTO {
    private Long id;
    private String text;
}
