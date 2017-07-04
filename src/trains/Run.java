package trains;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String trainsSchedule = "src/trains/files/schedule.xml";
        boolean addMoreTrain = true;
        Trains trains = new Trains();

        // Load existing schedule.
        try {
            trains = load(trainsSchedule);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        // Add new trains.
        Scanner scanner = new Scanner(System.in);
        while (addMoreTrain) {
            System.out.print("Do you want add train? yes/no ");
            if (scanner.nextLine().equals("yes")) {
                createTrain(trains);
            } else {
                addMoreTrain = false;
            }
        }

        // Print schedule.
        for (Train tr : trains) {
            System.out.println(tr);
        }

        // Save schedule.
        System.out.print("Save changes? yes/no ");
        if (scanner.next().equals("yes")) try {
            save(trainsSchedule, trains);
            System.out.println("Schedule successfully saved.\nBye!");
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void createTrain(Trains trains) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter train ID");
        int id = recursiveIntegerRequest(scanner, 1);

        System.out.println("Enter city from");
        String from = scanner.nextLine();

        System.out.println("Enter city to");
        String to = scanner.nextLine();

        System.out.println("Enter date with format dd.MM.yyyy");
        String date = recursiveDateRequest(scanner);

        System.out.println("Enter time with format HH:mm");
        String time = recursiveTimeRequest(scanner);

        trains.add(new Train(id, from, to, date, time));
    }

    private static Trains load(String path) throws JAXBException, FileNotFoundException {
        File xmlTrains = createFile(path);

        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Trains) unmarshaller.unmarshal(xmlTrains);
    }

    private static void save(String path, Trains trains) throws JAXBException, FileNotFoundException {
        File xmlTrains = createFile(path);

        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        // Readable format.
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Write xml to file.
        marshaller.marshal(trains, xmlTrains);
    }

    private static File createFile(String path) throws FileNotFoundException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + path + " not found.");
        }

        return file;
    }

    private static int recursiveIntegerRequest(Scanner sc, int min, int max) {
        int i = 0;

        while (true) {
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    i = sc.nextInt();
                    break;
                } else {
                    System.out.println("Please, enter valid integer.");
                    sc.next();
                }
            }
            if (i >= min && i <= max) break;
            else System.out.println("ID must be greater than " + min + " and less than " + max);
        }
        sc.nextLine();

        return i;
    }

    private static int recursiveIntegerRequest(Scanner sc, int min) {
        return recursiveIntegerRequest(sc, min, Integer.MAX_VALUE);
    }

    private static int recursiveIntegerRequest(Scanner sc) {
        return recursiveIntegerRequest(sc, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static String recursiveDateRequest(Scanner scanner) {
        String date;

        while (true) {
            date = scanner.next();
            try {
                validateDate(date);
                break;
            } catch (ParseException e) {
                System.out.println("Enter valid date to accordance with format.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return date;
    }

    private static String recursiveTimeRequest(Scanner scanner) {
        String time;

        while (true) {
            time = scanner.next();
            try {
                validateTime(time);
                break;
            } catch (ParseException e) {
                System.out.println("Enter valid time to accordance with format.");
            }
        }

        return time;
    }

    private static void validateDate(String date) throws ParseException, IllegalArgumentException {
        Calendar calendar = validateDateTime(date, "dd.MM.yyyy");

        int year = calendar.get(Calendar.YEAR);
        if (year < 2000 || year > 2020) {
            throw new IllegalArgumentException("Year should be greater than 2000 and less than 2020.");
        }
    }

    private static void validateTime(String time) throws ParseException {
        validateDateTime(time, "HH:mm");
    }

    private static Calendar validateDateTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        sdf.setCalendar(calendar);
        // Validation date.
        sdf.setLenient(false);
        // Parse for throwing exceptions if something is wrong.
        sdf.parse(date);

        return calendar;
    }
}
