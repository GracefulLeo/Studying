package yahoo.finance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "results")
public class Results {

    @XmlElement(name = "rate")
    Rate[] rates;

    @Override
    public String toString() {
        return "Results{" +
                "rates=" + Arrays.toString(rates) +
                '}';
    }
}
