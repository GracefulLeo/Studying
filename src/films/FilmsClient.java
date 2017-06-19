package films;

import films.comparators.FilmComparators;
import films.parsers.*;
import films.predicates.FilmPredicates;

import java.io.*;
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

        writeFilmsToBinFile("src/films/files/films.bin", films);
        Films films1 = readFilmsFromBinFile("src/films/files/write.bin");
        films1.sort(FilmComparators.byYear());

//        films = films.filter(FilmPredicates.yearSelection(2000, 2003));
        films = films.filter(FilmPredicates.withGenre(Genres.ROMANCE));
        films.sort(FilmComparators.byTitle());

        for (Film film : films) {
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

    static Films readFilmsFromBinFile(String path) {
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

    static void writeFilmsToBinFile(String path, Films films) {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutput.writeObject(films);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            System.out.println("Can't write file." + e.getMessage());
        }
    }
}
