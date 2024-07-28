package com.gamerum.backend.adaptor.dto.community.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateDTO {
    private String title;
    private String tag;
    private String text;
    private long writerProfileId;
}
