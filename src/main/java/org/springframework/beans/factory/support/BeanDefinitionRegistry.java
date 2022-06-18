package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author sakurafly
 * @date 2022/6/18 15:12
 */
public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
