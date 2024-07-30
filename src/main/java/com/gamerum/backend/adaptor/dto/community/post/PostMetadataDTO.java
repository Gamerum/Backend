package com.gamerum.backend.adaptor.dto.community.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class PostMetadataDTO {
    private Long id;
    private String title;
    private String tag;
    private String text;
    private String writerId;
    private String writerNickname;
    private Date createdDate;
    private Date lastModifiedDate;
}
