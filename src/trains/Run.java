package trains;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Run {
    public static void main(String[] args) {
        String trainsSchedule = "src/trains/files/schedule.xml";
        Trains trains = new Trains();

        try {
            trains = load(trainsSchedule);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (Train tr : trains) {
            System.out.println(tr);
        }
    }

    private static Trains load(String path) throws JAXBException {
        // @todo Add check on exists.
        File xmlTrains = new File(path);

        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Trains) unmarshaller.unmarshal(xmlTrains);
    }

    private static void save(String path, Trains trains) throws JAXBException {
        // @todo Add check on exists.
        File xmlTrains = new File(path);

        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        // Readable format.
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Write xml to file.
        marshaller.marshal(trains, xmlTrains);
    }
}
