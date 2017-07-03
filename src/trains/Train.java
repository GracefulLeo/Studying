package trains;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
class Train {
    private Train() {
    }

    public Train(int id, String from, String to, String date, String time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "from")
    private String from;
    @XmlElement(name = "to")
    private String to;
    @XmlElement(name = "date")
    private String date;
    @XmlElement(name = "departure")
    private String time;

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Train N" + id + "\n" +
                date + ' ' + time + "\n" +
                from + '-' + to + "\n";
    }
}
