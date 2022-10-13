package org.example;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author kiyota
 */
public class ThrowPlayground {

    private boolean finished;

    public boolean isFinished() {
        return finished;
    }

    public void throwPlayground(String fileName) throws Exception {
        try {
            Path resource = Path.of(ClassLoader.getSystemResource(fileName).toURI());
            String result = Files.readString(resource);
            System.out.println(result);
        } catch (Throwable e) {
            throw new Exception(e);
        }
        finished = true;
    }
}
