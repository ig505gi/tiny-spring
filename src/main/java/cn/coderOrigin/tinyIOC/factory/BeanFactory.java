package cn.coderOrigin.tinyIOC.factory;

import cn.coderOrigin.tinyIOC.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 13:36
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
