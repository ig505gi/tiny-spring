package cn.coderOrigin.tinyIOC.aop;

public class TargetSource {
    Object target;
    Class clazz;
    public TargetSource(Object target, Class clazz) {
        this.target = target;
        this.clazz = clazz;
    }

    public Object getTarget() {
        return target;
    }

    public Class getTargetClass() {
        return clazz;
    }
}
