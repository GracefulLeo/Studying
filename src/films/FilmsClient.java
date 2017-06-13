package films;

import films.comparators.CommonComparators;
import films.comparators.FilmComparators;
import films.predicates.FilmPredicates;

import java.util.Arrays;
import java.util.TreeSet;

public class FilmsClient {
    public static void main(String[] args) {
        Films films = new Films();
        films
                .add(new Film(1, "Avatar", 2009, new TreeSet<>(Arrays.asList(Genres.ACTION, Genres.ADVENTURE))))
                .add(new Film(2, "Avatar2", 2018, new TreeSet<>(Arrays.asList(Genres.ACTION, Genres.ADVENTURE))))
                .add(new Film(3, "Avatar3", 2019, new TreeSet<>(Arrays.asList(Genres.ACTION, Genres.ADVENTURE))));

        films = films.filter(FilmPredicates.idsSelection(1, 2));
        films.sort(CommonComparators.multiCriterion(FilmComparators.byId()));

        for (Film film : films) {
            System.out.print(film);
        }
    }
}
