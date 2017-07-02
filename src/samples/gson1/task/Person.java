package samples.gson1.task;

import java.util.Arrays;

public class Person {
    private String name;
    private String surname;
    private String[] phones;
    private Address address;

    private Person() {
    }

    @Override
    public String toString() {
        return "--- Person ---" + "\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Phones: " + Arrays.toString(phones) + "\n" +
                "Address: " + address + "\n" +
                "--------------";
    }
}
