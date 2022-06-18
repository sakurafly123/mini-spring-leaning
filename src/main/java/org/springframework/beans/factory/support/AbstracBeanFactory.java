package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author sakurafly
 * @date 2022/6/18 15:11
 */
public abstract class AbstracBeanFactory  extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
       Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);

    }

    protected abstract Object  createBean(String beanName,BeanDefinition beanDefinition);

    protected abstract BeanDefinition  getBeanDefinition(String beanName);

}
