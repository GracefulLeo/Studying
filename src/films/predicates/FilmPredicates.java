package films.predicates;

import films.Film;
import films.Genres;

import java.util.function.Predicate;

public class FilmPredicates {
    private FilmPredicates() {
    }

    public static Predicate<Film> withId(int id) {
        return film -> film.getId() == id;
    }

    public static Predicate<Film> idsSelection(int fromId, int toId) {
        return film -> film.getId() >= fromId && film.getId() <= toId;
    }

    public static Predicate<Film> withYear(int year) {
        return film -> film.getYear() == year;
    }

    public static Predicate<Film> yearSelection(int fromYear, int toYear) {
        return film -> film.getYear() >= fromYear && film.getYear() <= toYear;
    }

    public static Predicate<Film> withGenre(Genres genre) {
        return film -> film.getGenre().contains(genre);
    }

    public static Predicate<Film> genresSelection(Genres[] genre) {
        return film -> film.getGenre().contains(genre);
    }
}
