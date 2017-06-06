package films;

import java.util.*;

public class Films implements Iterable<Film> {
    private final List<Film> films = new ArrayList<>();

    public void add(Film film) {
        films.add(film);
    }

    public List<Film> sort(Sortable sorter) {
        List<Film> films = new ArrayList<>();

        for (Film f : this.films) {
            films.add(f);
        }

        return films;
    }

    @Override
    public Iterator<Film> iterator() {
        return films.iterator();
    }
}
