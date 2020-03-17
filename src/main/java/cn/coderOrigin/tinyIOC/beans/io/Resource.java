package cn.coderOrigin.tinyIOC.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gao Yuan
 * @date 2020-03-03 - 20:47
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
