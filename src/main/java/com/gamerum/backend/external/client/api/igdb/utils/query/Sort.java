package com.gamerum.backend.external.client.api.igdb.utils.query;

public enum Sort {
    ASC,
    DESC;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
