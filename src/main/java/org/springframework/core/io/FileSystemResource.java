package org.springframework.core.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * @author sakurafly
 * @date 2022/6/27 23:05
 */
public class FileSystemResource implements Resource{

    private final String filepath;

    public FileSystemResource(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        try {
            Path path = new File(this.filepath).toPath();
            return Files.newInputStream(path);
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }
}
