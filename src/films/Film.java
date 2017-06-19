package films;

import java.io.Serializable;
import java.util.Set;

public class Film implements Serializable {
    private static long serialVersionUID = 1L;

    private final int id;
    private final String title;
    private final int year;
    private final Set<Genres> genres;

    public Film(int id, String title, int year, Set<Genres> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Set<Genres> getGenre() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (year != film.year) return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;
        return genres != null ? genres.equals(film.genres) : film.genres == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title + ": \t" + year + "\t" + genres.toString() + "\n";
    }
}
