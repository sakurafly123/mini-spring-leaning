package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author sakurafly
 * @date 2022/6/18 16:01
 */
public interface InstantiaionStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
