package com.gamerum.backend.adaptor.dto.community.post.comment.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReplyGetDTO {
    private Long id;
    private String text;
    private Long commentId;
    private Long writerId;
    private String writerNickname;
    private Date createdDate;
    private Date lastModifiedDate;
}
