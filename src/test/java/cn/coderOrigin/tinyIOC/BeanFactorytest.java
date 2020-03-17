package cn.coderOrigin.tinyIOC;

import cn.coderOrigin.tinyIOC.beans.BeanDefinition;
import cn.coderOrigin.tinyIOC.beans.factory.AbstractBeanFactory;
import cn.coderOrigin.tinyIOC.beans.factory.AutowireCapableBeanFactory;
import cn.coderOrigin.tinyIOC.beans.io.ResourceLoader;
import cn.coderOrigin.tinyIOC.beans.xml.XmlBeanDefinitionReader;
import cn.coderOrigin.tinyIOC.context.ApplicationContext;
import cn.coderOrigin.tinyIOC.context.ClassPathXmlApplicationContext;
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

    @Test
    public void testContext() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
