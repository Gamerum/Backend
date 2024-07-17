package com.gamerum.backend.external.client.api.igdb.utils;

public enum Sort {
    ASC,
    DESC;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
