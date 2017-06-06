package films;

public class FilmsClient {
    public static void main(String[] args) {
        Films films = new Films();
        films.add(new Film("Avatar", 2009));
        films.add(new Film("Avatar2", 2018));
        films.add(new Film("Avatar3", 2019));

        for (Film film : films) {
            System.out.print(film);
        }
    }
}
