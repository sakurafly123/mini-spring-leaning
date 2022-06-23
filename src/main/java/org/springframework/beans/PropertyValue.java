package org.springframework.beans;

/**
 * @author sakurafly
 * @date 2022/6/20 23:13
 */
public class PropertyValue {

    private  String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
