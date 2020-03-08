package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-03-08 - 17:53
 */
public class BeanReference {
    private String name;
    private Object bean;


    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
