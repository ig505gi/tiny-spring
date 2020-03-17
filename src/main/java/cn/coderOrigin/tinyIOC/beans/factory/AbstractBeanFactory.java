package cn.coderOrigin.tinyIOC.beans.factory;

import cn.coderOrigin.tinyIOC.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:57
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named" + name + "defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for(Iterator it = beanDefinitionNames.iterator(); it.hasNext();) {
            String name = (String) it.next();
            getBean(name);
        }
    }

    public abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
