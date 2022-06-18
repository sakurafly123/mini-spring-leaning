package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sakurafly
 * @date 2022/6/18 14:39
 */
public interface BeanFactory {

    Object getBean(String  name)  throws Exception;
}
