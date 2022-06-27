package org.springframework.beans.factory;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import org.springframework.core.io.DefaultRsourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sakurafly
 * @date 2022/6/27 23:19
 */
public class ResourceAndResourceLoaderTest {


    @Test
    public void testResourceLoader() throws Exception{
        DefaultRsourceLoader resourceLoader = new DefaultRsourceLoader();
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        assertThat(resource instanceof FileSystemResource).isTrue();
        inputStream =resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        resource = resourceLoader.getResource("https://github.com/DerekYRC/mini-spring/blob/main/README.md");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);



    }
}
