package org.springframework.beans.factory;

/**
 * @author sakurafly
 * @date 2022/6/18 15:40
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
