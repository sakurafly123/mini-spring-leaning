package org.springframework.beans.factory.config;

/**
 * @author sakurafly
 * @date 2022/6/18 15:10
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String name);
}
