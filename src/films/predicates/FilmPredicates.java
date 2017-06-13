package films.predicates;

import films.Film;

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
}
