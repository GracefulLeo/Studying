package FileReader;

public class FileReaderRunner {
    public static void main(String[] args) {
        MyFileReader r = new MyFileReader("src/FileReader/file.txt");
        String[] list = r.readAll();

        for (String s : list) {
            System.out.println(s);
        }
    }
}
