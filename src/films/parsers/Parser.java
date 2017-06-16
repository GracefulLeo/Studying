package films.parsers;

public interface Parser<T> {
    T parse(String s);
}
