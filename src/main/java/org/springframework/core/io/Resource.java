package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sakurafly
 * @date 2022/6/27 23:02
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
