import cn.coderOrigin.tinyIOC.BeanDefinition;
import cn.coderOrigin.tinyIOC.BeanFactory;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:43
 */

public class testStep1 {
    public static void main(String[] args) {
        // 1.初始化beanFactory
        BeanFactory factory = new BeanFactory();

        // 2.注册Bean对象
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        factory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.直接调用bean对象
        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
