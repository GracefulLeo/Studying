package films.parsers;

public class IdParser implements Parser<Integer> {
    @Override
    public Integer parse(String s) {
        s = s.trim();

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("ID must be integer. " + e.getMessage());
        }
    }
}
