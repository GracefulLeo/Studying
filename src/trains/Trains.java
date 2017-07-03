package trains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@XmlRootElement(name = "trains")
public class Trains implements Iterable<Train> {

    @XmlElement(name = "train")
    private final List<Train> trains = new ArrayList<>();

    public Trains add(Train train) {
        trains.add(train);
        return this;
    }

    public Trains filter(Predicate<Train> predicate) {
        Trains trains = new Trains();

        for (Train train : this.trains) {
            if (predicate.test(train)) {
                trains.add(train);
            }
        }

        return trains;
    }

    @Override
    public Iterator<Train> iterator() {
        return trains.iterator();
    }

    @Override
    public String toString() {
        return "Trains:\n" + trains;
    }
}
