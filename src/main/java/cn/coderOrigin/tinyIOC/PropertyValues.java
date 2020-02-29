package cn.coderOrigin.tinyIOC;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Yuan
 * @date 2020-02-29 - 18:28
 */
public class PropertyValues {
    // 这里别人用了 final 直接创建
    //  List<PropertyValue> propertyValueList = null;
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return this.propertyValueList;
    }
}
