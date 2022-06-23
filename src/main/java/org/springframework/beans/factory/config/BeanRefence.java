package org.springframework.beans.factory.config;

/**
 * @author sakurafly
 * @date 2022/6/23 23:25
 */
public class BeanRefence {

    private final String beanName;

    public BeanRefence(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
