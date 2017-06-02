package samples;

import java.util.Scanner;

public class SwitchSimple {
    public static void main(String[] args) {
        System.out.println("Enter your memory size like: \"8 GB\" or \"100 kb\"");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        String[] strings = input.split("\\s+");

        long bytes;
        try {
            bytes = Integer.parseInt(strings[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("Number must be entered first");
            return;
        }

        String size = strings.length > 1 ? strings[1] : "";

        switch (size.toUpperCase()) {
            case "GB":
                bytes *= 1024;
            case "MB":
                bytes *= 1024;
            case "KB":
                bytes *= 1024;
        }

        System.out.println("It is " + bytes + " bytes.");
    }
}
