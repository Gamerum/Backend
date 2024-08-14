package com.gamerum.backend.adaptor.dto.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
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
    private PostDocument.Profile writer;
    private PostDocument.Community community;
    private Date createdDate;
    private Date lastModifiedDate;
    private List<CommentGetDTO> firstPageComments;
}
