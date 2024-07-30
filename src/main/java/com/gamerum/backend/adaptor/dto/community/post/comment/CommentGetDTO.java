package com.gamerum.backend.adaptor.dto.community.post.comment;

import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentGetDTO {
    private Long id;
    private String text;
    private Long writerId;
    private String writerNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
