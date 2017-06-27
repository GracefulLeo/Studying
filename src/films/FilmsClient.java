package films;

import films.comparators.CommonComparators;
import films.comparators.FilmComparators;
import films.parsers.*;
import films.predicates.FilmPredicates;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FilmsClient {
    public static void main(String[] args) {
        // Defines films from csv file.
        Films films = new Films();

        // Read and parse films list from csv file.
        ArrayList<ArrayList<String>> list = readCSVFile("src/films/files/films.csv");

        for (ArrayList<String> line : list) {
            Integer id = new IdParser().parse(line.get(0));
            String title = new TitleParser().parse(line.get(1));
            Integer year = new YearParser().parse(line.get(2));
            TreeSet<Genres> genres = new GenresParser().parse(line.get(3));

            films.add(new Film(id, title, year, genres));
        }

        // Save films to bin file.
        writeFilmsToBinFile("src/films/files/films.bin", films);

        // Read new films list from bin file.
        Films films1 = readFilmsFromBinFile("src/films/files/films.bin");

        // Filter and sort films.
        assert films1 != null;
        films1 = films1.filter(FilmPredicates.withGenre(Genres.DRAMA));
        films1.sort(CommonComparators.multiCriterion(FilmComparators.byYear(), FilmComparators.byTitle()));

        // Print films.
        for (Film film : films1) {
            System.out.print(film);
        }

        try (PrintWriter printWriter = new PrintWriter(new File("src/films/files/write.txt"))) {
            for (Film film : films) {
                printWriter.print(film.toString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<ArrayList<String>> readCSVFile(String path) {
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

    private static Films readFilmsFromBinFile(String path) {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(path))) {
            return (Films) objectInput.readObject();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + e.getClass() + " not found.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static void writeFilmsToBinFile(String path, Films films) {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutput.writeObject(films);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            System.out.println("Can't write file." + e.getMessage());
        }
    }
}
