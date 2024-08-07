package com.gamerum.backend.external.persistence.elasticsearch.document;


import com.fasterxml.jackson.annotation.JsonIgnore;

public interface DocumentBase {
    String getId();
    @JsonIgnore
    String getIndex();
}
