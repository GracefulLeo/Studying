package films.parsers;

import java.util.Calendar;

public class YearParser implements Parser<Integer> {
    @Override
    public Integer parse(String s) {
        s = s.trim();

        try {
            Integer year = Integer.parseInt(s);

            if (year < 1870 || year > Calendar.getInstance().get(Calendar.YEAR)) {
                throw new IllegalArgumentException(year.toString());
            }

            return year;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Year must be integer. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Illegal year: " + e.getMessage());
        }
    }
}
