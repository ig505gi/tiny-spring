package cn.coderOrigin.tinyIOC.context;

import cn.coderOrigin.tinyIOC.beans.factory.AbstractBeanFactory;

/**
 * @author Gao Yuan
 * @date 2020-03-17 - 13:46
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
