package films.parsers;

import films.Genres;

import java.util.TreeSet;

public class GenresParser implements Parser<TreeSet<Genres>> {
    @Override
    public TreeSet<Genres> parse(String s) {
        TreeSet<Genres> set = new TreeSet<>();

        try {
            String[] genres = s.split(",");

            for (String genre : genres) {
                genre = genre.trim().toUpperCase();
                genre = genre.replace('-', '_');

                if (!isGenre(genre)) {
                    throw new IllegalArgumentException("The genre \"" + genre + "\" is not listed.");
                }

                set.add(Genres.valueOf(genre));
            }

            return set;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static boolean isGenre(String s) {
        try {
            Genres.valueOf(s);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
