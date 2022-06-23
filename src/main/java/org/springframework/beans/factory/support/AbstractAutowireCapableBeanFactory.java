package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanRefence;

import java.lang.reflect.Field;

/**
 * @author sakurafly
 * @date 2022/6/18 15:11
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstracBeanFactory{

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
     return doCreateBean(beanName,beanDefinition);
    }

    protected  Object doCreateBean(String beanName, BeanDefinition beanDefinition){
        Class beanClass = beanDefinition.getBeanClass();

        Object bean = null;
        try {
            bean = createInstance(beanDefinition);
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
          throw new BeansException("Instantiation of bean failed",e);
        }

        addSingleton(beanName,bean);

        return bean;
    }

    protected  void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        try {
            for (PropertyValue propertyValue : propertyValues.propertyValueToArry()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanRefence) {
                    BeanRefence beanRefence =(BeanRefence)value;
                    value = getBean(beanRefence.getBeanName());
                }

                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values for bean: " + beanName, e);

        }

    }

    protected Object createInstance(BeanDefinition beanDefinition) {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
