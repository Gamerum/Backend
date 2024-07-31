package com.gamerum.backend.adaptor.dto.community.post.comment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CommentResponseGetDTO {
    private Long id;
    private String text;
    private Long commentId;
    private Long writerId;
    private String writerNickname;
    private Date createdDate;
    private Date lastModifiedDate;
}
