package cn.coderOrigin.tinyIOC;

import cn.coderOrigin.tinyIOC.factory.AbstractBeanFactory;
import cn.coderOrigin.tinyIOC.factory.AutowireCapableBeanFactory;
import cn.coderOrigin.tinyIOC.factory.BeanFactory;
import cn.coderOrigin.tinyIOC.io.ResourceLoader;
import cn.coderOrigin.tinyIOC.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;


/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:43
 */

public class BeanFactorytest {

    // step
    @Test
    public void stepLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyIOC.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void stepPreInstan() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyIOC.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3. 初始化bean
        beanFactory.preInstantiateSingletons();

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
