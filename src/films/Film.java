package films;

public class Film {
    private final String title;
    private final int year;

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (year != film.year) return false;

        return title.equals(film.title);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return title + ": \t" + year + "\n";
    }
}
