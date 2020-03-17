package cn.coderOrigin.tinyIOC.beans;

import cn.coderOrigin.tinyIOC.beans.io.ResourceLoader;

import java.util.HashMap;

/**
 * @author Gao Yuan
 * @date 2020-03-03 - 21:48
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private HashMap<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public HashMap<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
