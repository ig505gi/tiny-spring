package cn.coderOrigin.tinyIOC.beans.factory;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 13:36
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
