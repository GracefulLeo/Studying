package films.parsers;

public class TitleParser implements Parser<String> {
    @Override
    public String parse(String s) {
        return s.trim();
    }
}
