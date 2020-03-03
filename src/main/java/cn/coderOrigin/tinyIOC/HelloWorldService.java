package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-02-25 - 14:48
 */
public class HelloWorldService {

    private String text;

    public void helloWorld() {
        System.out.println(this.text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
