package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author sakurafly
 * @date 2022/6/18 16:05
 */
public class CglibSubclassingInstantiationStrategy  implements InstantiaionStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        return null;
    }
}
