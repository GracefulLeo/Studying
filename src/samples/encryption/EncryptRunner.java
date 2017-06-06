package samples.encryption;

public class EncryptRunner {
    public static void main(String[] args) {
        Encryptable encoded = new Encoder("Hello world! My name is Dima.");
        Encryptable decoded = new Decoder(encoded.encrypt());

        System.out.println(encoded.encrypt());
        System.out.println(decoded.encrypt());
    }
}
