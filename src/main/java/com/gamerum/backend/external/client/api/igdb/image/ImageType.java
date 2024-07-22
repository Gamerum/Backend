package com.gamerum.backend.external.client.api.igdb.image;

public enum ImageType {
    JPEG,
    PNG,
    GIF,
    WEBP;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
