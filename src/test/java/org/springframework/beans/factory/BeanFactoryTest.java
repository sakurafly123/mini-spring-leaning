package org.springframework.beans.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sakurafly
 * @date 2022/6/18 14:50
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register("helloService",new HelloService());
        HelloService helloService = (HelloService)beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.print()).isEqualTo("hello");

    }

    class HelloService {

        private String print() {
            System.out.println("hello");
            return "hello";
        }
    }

}

