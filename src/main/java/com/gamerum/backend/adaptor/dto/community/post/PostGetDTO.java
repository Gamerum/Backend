package com.gamerum.backend.adaptor.dto.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostGetDTO {
    private Long id;
    private String title;
    private String tag;
    private String text;
    private String writerId;
    private String writerNickname;
    private Date createdDate;
    private Date lastModifiedDate;
    private Long communityId;
    private String communityName;
    private List<CommentGetDTO> firstPageComments;
}
