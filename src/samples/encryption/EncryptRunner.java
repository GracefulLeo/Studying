package samples.encryption;

public class EncryptRunner {
    public static void main(String[] args) {
        Encryptable decoded = new Decoder("Hello world!");
        Encryptable encoded = new Encoder(decoded.encrypt());

        System.out.println(decoded.encrypt());
        System.out.println(encoded.encrypt());
    }
}
