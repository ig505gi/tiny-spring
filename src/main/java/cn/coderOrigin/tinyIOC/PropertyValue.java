package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-02-29 - 18:27
 */
public class PropertyValue {

    private String key;

    private Object value;

    public PropertyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
