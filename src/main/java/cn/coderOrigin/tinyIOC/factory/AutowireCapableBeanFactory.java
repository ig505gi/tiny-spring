package cn.coderOrigin.tinyIOC.factory;

import cn.coderOrigin.tinyIOC.BeanDefinition;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:59
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    public Object doCreatBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
