package samples.gson1.task.reader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class JSONRandomAccessFileReader implements JSONReader {
    @Override
    public String read(String path) throws IOException {
        try (RandomAccessFile f = new RandomAccessFile(path, "r")) {
            byte[] buf = new byte[(int) f.length()];

            f.read(buf);

            return new String(buf);
        }
    }
}
