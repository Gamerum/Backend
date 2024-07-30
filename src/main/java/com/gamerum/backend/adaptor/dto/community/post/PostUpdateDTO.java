package com.gamerum.backend.adaptor.dto.community.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDTO {
    private String title;
    private String tag;
    private String text;
}
