package com.gamerum.backend.external.client.api.game.igdb.utils.query;

public enum Sort {
    ASC,
    DESC;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
