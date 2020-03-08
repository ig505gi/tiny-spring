package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-03-06 - 17:22
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text) {
        if (helloWorldService != null) {
            System.out.println(text);
        }
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
