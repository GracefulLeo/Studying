package samples.gson1.task.reader;

import java.io.IOException;

public interface JSONReader {
    String read(String path) throws IOException;
}
