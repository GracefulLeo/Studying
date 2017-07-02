package samples.gson1.task;

import com.google.gson.GsonBuilder;
import samples.gson1.task.reader.JSONBufferedReader;
import samples.gson1.task.reader.JSONReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src/samples/gson1/task/files/person.json";

        JSONReader reader = new JSONBufferedReader();

        try {
            String json = reader.read(path);

            Person person = new GsonBuilder().create().fromJson(json, Person.class);

            System.out.println(person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
