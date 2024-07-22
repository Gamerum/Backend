package com.gamerum.backend.external.persistence.file;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class FileRepository {
    private final String RESOURCES_DIR = "src/main/resources";

    public void writeFileToExternalDirectory(String fileName, String content) throws IOException {
        Path filePath = Paths.get(RESOURCES_DIR, fileName);
        Files.createDirectories(filePath.getParent()); // Ensure directory exists
        Files.writeString(filePath, content);
    }

    public String readFileFromExternalDirectory(String filename) throws IOException {
        Path filePath = Paths.get(RESOURCES_DIR, filename);
        try{
            return Files.readString(filePath);
        }catch (NoSuchFileException e) {
            throw new IOException(e);
        }
    }
}
