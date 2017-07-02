package samples.gson1.task.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONBufferedReader implements JSONReader {
    @Override
    public String read(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }

            return new String(builder);
        }
    }
}
