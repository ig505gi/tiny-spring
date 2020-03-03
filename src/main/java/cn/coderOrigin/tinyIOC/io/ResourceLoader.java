package cn.coderOrigin.tinyIOC.io;

import java.net.URL;

/**
 * @author Gao Yuan
 * @date 2020-03-03 - 20:48
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resouce = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resouce);
    }
}

