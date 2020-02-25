package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 13:37
 */
public class BeanDefinition {
    Object bean;

    Class beanClass;

    String beanClassName;

    public BeanDefinition() {
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
