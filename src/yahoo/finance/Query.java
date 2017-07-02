package yahoo.finance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
    public int count;
    public String created;
    public String lang;
    @XmlElement(name = "results")
    Results results;

    @Override
    public String toString() {
        return "Query{" +
                "results=" + results +
                '}';
    }
}
