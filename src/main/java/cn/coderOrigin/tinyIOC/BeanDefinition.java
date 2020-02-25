package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 13:37
 */
public class BeanDefinition {
    Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
