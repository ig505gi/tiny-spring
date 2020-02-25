package cn.coderOrigin.tinyIOC;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 13:36
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
