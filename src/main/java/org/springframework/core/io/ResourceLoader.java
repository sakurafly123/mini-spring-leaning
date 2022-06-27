package org.springframework.core.io;

/**
 * @author sakurafly
 * @date 2022/6/27 23:03
 */
public interface ResourceLoader {

    Resource getResource(String location) ;
}
