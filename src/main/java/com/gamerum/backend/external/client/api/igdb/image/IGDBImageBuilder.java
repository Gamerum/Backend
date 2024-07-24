package com.gamerum.backend.external.client.api.igdb.image;

public class IGDBImageBuilder {
    private final String imageUrl = "https://images.igdb.com/igdb/image/upload/";

    private ImageSize size;
    private ImageType type;

    public static IGDBImageBuilder builder() {
        return new IGDBImageBuilder();
    }

    public String build(String imageId, ImageSize size, ImageType type){
        return imageUrl + size + "/" + imageId + "." + type;
    }

}
