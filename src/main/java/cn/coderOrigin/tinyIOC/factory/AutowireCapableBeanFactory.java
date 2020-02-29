package cn.coderOrigin.tinyIOC.factory;

import cn.coderOrigin.tinyIOC.BeanDefinition;
import cn.coderOrigin.tinyIOC.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:59
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = creatBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private Object creatBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }
    // 这里需要用反射，遍历propertyValues中的各个pv，将其赋值给bean的属性
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for(PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field field = beanDefinition.getBeanClass().getDeclaredField(pv.getKey());
            field.setAccessible(true);
            field.set(bean, pv.getValue());
        }
    }

}
