package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author sakurafly
 * @date 2022/6/18 15:11
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstracBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();

        Object object = null;
        try {
            object = beanClass.newInstance();
        } catch (Exception e) {
           throw new BeansException("instantiation fo bean failed",e);
        }

        addSingleton(beanName,object);

        return object;
    }

}
