package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sakurafly
 * @date 2022/6/18 15:30
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonObjects =new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    protected void addSingleton(String name, Object singletonObject) {
        singletonObjects.put(name,singletonObject);
    }

}
