package yahoo.finance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "rate")
public class Rate {

    int id;

    @XmlElement(name = "Name")
    String name;

    @XmlElement(name = "Rate")
    double rate;

    @XmlElement(name = "Date")
    Date date;

    @XmlElement(name = "Time")
    String time;

    @XmlElement(name = "Ask")
    double ask;

    @XmlElement(name = "Bid")
    double bid;

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
