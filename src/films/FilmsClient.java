package films;

import films.comparators.FilmComparators;
import films.parsers.*;
import films.predicates.FilmPredicates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class FilmsClient {
    public static void main(String[] args) {
        Films films = new Films();
        ArrayList<ArrayList<String>> list = readCSVFile("src/films/files/films.csv");

        for (ArrayList<String> line : list) {
            Integer id = new IdParser().parse(line.get(0));
            String title = new TitleParser().parse(line.get(1));
            Integer year = new YearParser().parse(line.get(2));
            TreeSet<Genres> genres = new GenresParser().parse(line.get(3));

            films.add(new Film(id, title, year, genres));
        }

//        films = films.filter(FilmPredicates.yearSelection(2000, 2003));
        films = films.filter(FilmPredicates.withGenre(Genres.ROMANCE));
        films.sort(FilmComparators.byTitle());

        for (Film film : films) {
            System.out.print(film);
        }
    }

    static ArrayList<ArrayList<String>> readCSVFile(String path) {
        ArrayList<ArrayList<String>> parsedStrings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                ArrayList<String> words = CSVParser.parseLine(line);

                parsedStrings.add(words);
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return parsedStrings;
    }
}
