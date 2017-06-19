package films;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;

public class Films implements Iterable<Film>, Serializable {
    private final List<Film> films = new ArrayList<>();

    public Films add(Film film) {
        films.add(film);
        return this;
    }

    public Films filter(Predicate<Film> predicate) {
        Films res = new Films();

        for (Film f : films) {
            if (predicate.test(f)) {
                res.add(f);
            }
        }

        return res;
    }

    public void sort(Comparator<Film> comparator) {
        films.sort(comparator);
    }

    @Override
    public Iterator<Film> iterator() {
        return films.iterator();
    }
}
