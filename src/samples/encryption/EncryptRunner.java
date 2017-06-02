package samples.encryption;

public class EncryptRunner {
    private final String string;

    public static void main(String[] args) {
        EncryptRunner s = new EncryptRunner("Hello world!");
        String encoded = s.encode();
        System.out.println(encoded);
        EncryptRunner encoded2 = new EncryptRunner(encoded);
        String decoded = encoded2.decode();
        System.out.println(decoded);
    }

    public EncryptRunner(String s) {
        this.string = s;
    }

    public String encode() {
        char[] chars = string.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            builder.append(c += 100);
        }

        return builder.toString();
    }

    public String decode() {
        char[] chars = string.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            builder.append(c -= 100);
        }

        return builder.toString();
    }
}
