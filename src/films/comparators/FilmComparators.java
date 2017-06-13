package films.comparators;

import films.Film;

import java.util.Comparator;

public class FilmComparators {
    private FilmComparators() {
    }

    public static Comparator<Film> byId() {
        return Comparator.comparingInt(Film::getId);
    }

    public static Comparator<Film> byTitle() {
        return Comparator.comparing(Film::getTitle);
    }

    public static Comparator<Film> byYear() {
        return Comparator.comparingInt(Film::getYear);
    }
}
