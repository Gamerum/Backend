package com.gamerum.backend.external.persistence.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class LikeableDocument implements DocumentBase{
    protected List<String> likedByProfileIds;
}
