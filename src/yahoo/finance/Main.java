package yahoo.finance;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
        String filePath = "src/yahoo/finance/files/finance.xml";

        try {
            String xml = readXMLFromAPI(request);
            writeXMLToFile(filePath, xml);
            Query query = parseXML(filePath);

            System.out.println("1 UAH = " + query.results.rates[1].getRate() + " USD");

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String readXMLFromAPI(String path) throws IOException {
        URL url = new URL(path);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        StringBuilder xml = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                xml.append(line);
            }
        } finally {
            connection.disconnect();
        }

        return new String(xml);
    }

    private static void writeXMLToFile(String filePath, String xml) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(xml);
        }
    }

    private static Query parseXML(String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Query) unmarshaller.unmarshal(new File(filePath));
    }
}
