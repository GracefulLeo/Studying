package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class MyFileReader {
    private final String source;

    MyFileReader(String source) {
        this.source = source;
    }

    String[] readAll() {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return list.toArray(new String[]{});
    }
}
