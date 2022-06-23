package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakurafly
 * @date 2022/6/20 23:13
 */
public class PropertyValues {

   private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValues.add(pv);
    }

    public PropertyValue[] propertyValueToArry(){
       return  this.propertyValues.toArray(new PropertyValue[0]);
    }

    public Object getValue(String name) {
        return propertyValues.stream().filter(keys->keys.equals(name)).findFirst().get().getValue();
    }
}
