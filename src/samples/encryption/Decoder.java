package samples.encryption;

public class Decoder implements Encryptable {
    private final String text;

    public Decoder(String text) {
        this.text = text;
    }

    @Override
    public String encrypt() {
        char[] chars = text.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            builder.append(c -= 100);
        }

        return builder.toString();
    }
}
