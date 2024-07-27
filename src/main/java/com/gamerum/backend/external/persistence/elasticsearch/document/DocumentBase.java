package com.gamerum.backend.external.persistence.elasticsearch.document;


import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class DocumentBase {
    public abstract String getId();
    @JsonIgnore
    public abstract String getIndex();
}
