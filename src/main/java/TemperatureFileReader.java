import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TemperatureFileReader {

    private static final Logger LOG = LogManager.getLogger(TemperatureFileReader.class);
    private TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();

    public void readFile(String path){
        if(new File(path).exists()){
            LOG.debug("File at location "+ path +" does exists");
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8")))){
                String line;
                while ((line = br.readLine()) != null){
                    long UUID = Long.parseLong(line.split(";")[0]);
                    LocalDateTime timestamp = TemperatureFileReader.getTimeStamp(line.split(";")[1]);
                    float temperature = Float.parseFloat(line.split(";")[2]);
                    int humidity = Integer.parseInt(line.split(";")[3]);

                    temperaturVerlauf.add(new Measurement(Temperature.createFromCelsius(temperature),timestamp));
                }
                LOG.debug("Number of temperatures added to history: "+temperaturVerlauf.getCount());
            }catch (IOException iox){
                LOG.error("I/O Error while reading file", iox);
            }
        }else{
            LOG.warn("File doesnt exist", path);
        }
    }

    public void printStatistics(){
        System.out.println("Was war im gesamten Zeitraum die tiefste und die höchste Temperatur?");
        System.out.println(temperaturVerlauf.getMinTemperatureObject().getTemperature().getCelsius()+" am "+
                temperaturVerlauf.getMinTemperatureObject().getDateTime());
        System.out.println(temperaturVerlauf.getMaxTemperatureObject().getTemperature().getCelsius()+" am "+
                temperaturVerlauf.getMaxTemperatureObject().getDateTime());

        System.out.println("Was war die Durchschnittstemperatur?");
        System.out.println(temperaturVerlauf.getAvgTemperatureObject().getCelsius());
    }

    private static LocalDateTime getTimeStamp(String time){
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
    }
}
