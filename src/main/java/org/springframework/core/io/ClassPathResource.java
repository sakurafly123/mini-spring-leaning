package org.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author sakurafly
 * @date 2022/6/27 23:04
 */
public class ClassPathResource implements Resource{

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }
}
