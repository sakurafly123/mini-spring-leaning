package org.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sakurafly
 * @date 2022/6/27 23:03
 */
public class DefaultRsourceLoader implements ResourceLoader{

    public static final String CLASSPATH_URL_PREFIX = "classpath:";


    @Override
    public Resource getResource(String location)  {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return new FileSystemResource(location);
            }
        }
    }
}
