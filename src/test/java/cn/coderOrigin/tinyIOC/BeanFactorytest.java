package cn.coderOrigin.tinyIOC;

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
    // step1
//    @Test
//    public void step1() {
//        // 1.初始化beanFactory
//        BeanFactory factory = new BeanFactory();
//
//        // 2.注册Bean对象
//        BeanDefinition beanDefinition = new BeanDefinition(new cn.coderOrigin.tinyIOC.HelloWorldService());
//        factory.registerBeanDefinition("helloWorldService", beanDefinition);
//
//        // 3.直接调用bean对象
//        cn.coderOrigin.tinyIOC.HelloWorldService helloWorldService = (cn.coderOrigin.tinyIOC.HelloWorldService) factory.getBean("helloWorldService");
//        helloWorldService.helloWorld();
//    }

    // step2
    @Test
    public void step2() throws Exception{
        // 1.初始化beanFactory
        BeanFactory factory = new AutowireCapableBeanFactory();

        // 2.注入Bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("cn.coderOrigin.tinyIOC.HelloWorldService");
        factory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    // step3
    @Test
    public void step3() throws Exception{
        // 1. 初始化beanFactory
        BeanFactory factory = new AutowireCapableBeanFactory();

        // 2.初始化beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("cn.coderOrigin.tinyIOC.HelloWorldService");

        // 3. 注入属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));

        // 4.生成bean
        beanDefinition.setPropertyValues(propertyValues);
        factory.registerBeanDefinition("HelloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("HelloWorldService");
        helloWorldService.helloWorld();
    }
    // step4
    @Test
    public void step4() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyIOC.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
