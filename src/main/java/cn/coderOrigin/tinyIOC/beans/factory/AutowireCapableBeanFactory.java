package cn.coderOrigin.tinyIOC.beans.factory;

import cn.coderOrigin.tinyIOC.beans.BeanDefinition;
import cn.coderOrigin.tinyIOC.beans.BeanReference;
import cn.coderOrigin.tinyIOC.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:59
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    // 这里需要用反射，遍历propertyValues中的各个pv，将其赋值给bean的属性
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for(PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field field = beanDefinition.getBeanClass().getDeclaredField(pv.getKey());
            field.setAccessible(true);
            Object value = pv.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            field.set(bean, value);
        }
    }

}
