package com.gamerum.backend.adaptor.dto.community.post.comment.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyUpdateDTO {
    private Long id;
    private String text;
}

