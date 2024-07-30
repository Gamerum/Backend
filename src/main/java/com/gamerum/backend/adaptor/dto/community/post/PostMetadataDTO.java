package com.gamerum.backend.adaptor.dto.community.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostMetadataDTO {
    private Long id;
    private String title;
    private String tag;
    private String text;
    private String writerId;
    private String writerNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
