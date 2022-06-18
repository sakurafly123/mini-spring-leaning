package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sakurafly
 * @date 2022/6/18 14:39
 */
public class BeanFactory {

    private Map<String, Object> beanMap = new HashMap<>();

    Object getBean(String name)  throws Exception {
        return beanMap.get(name);
    }

    public void register(String name, Object bean) {
        beanMap.put(name, bean);
    }

}
