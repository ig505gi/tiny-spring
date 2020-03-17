package cn.coderOrigin.tinyIOC.context;

import cn.coderOrigin.tinyIOC.beans.BeanDefinition;
import cn.coderOrigin.tinyIOC.beans.factory.AbstractBeanFactory;
import cn.coderOrigin.tinyIOC.beans.factory.AutowireCapableBeanFactory;
import cn.coderOrigin.tinyIOC.beans.io.ResourceLoader;
import cn.coderOrigin.tinyIOC.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author Gao Yuan
 * @date 2020-03-17 - 13:47
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3. 初始化bean
        // beanFactory.preInstantiateSingletons();
    }
}
