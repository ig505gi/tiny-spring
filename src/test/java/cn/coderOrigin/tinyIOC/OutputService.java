package cn.coderOrigin.tinyIOC;

/**
 * @author Gao Yuan
 * @date 2020-03-06 - 17:22
 */
public class OutputService {

    private HelloWorldServiceImpl helloWorldService;

    public void output(String text) {
        if (helloWorldService != null) {
            System.out.println(text);
        }
    }

    public void setHelloWorldService(HelloWorldServiceImpl helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
