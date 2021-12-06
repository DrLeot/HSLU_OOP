import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TemperaturVerlaufInput {

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlaufInput.class);

    public static void main(String[] args) {
        LOG.debug("Startup of InputTest");
        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.addPropertyChangeListener(System.out::println);
        temperaturVerlauf.addPropertyChangeListener(System.out::println);

        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            LOG.info("User entered: " + input);
            try{
                float value = Float.parseFloat(input);
                temperaturVerlauf.add(new Measurement(Temperature.createFromKelvin(value)));
                LOG.info("Converted to: " + temperaturVerlauf);
            } catch (IllegalArgumentException ex){
                LOG.error(ex);
            }
        } while (!input.equals("exit"));
        temperaturVerlauf.removeAllPropertyChangeListener(); // cleanup
        System.out.println("Programm wird beendet. Statistik:");
        System.out.println("Anzahl Werte:\t\t"+temperaturVerlauf.getCount());
        System.out.println("Durchschnitt:\t\t"+temperaturVerlauf.getAvgTemperatureObject());
        System.out.println("Summe:\t\t"+temperaturVerlauf.getSumTemperatureValues());
        System.out.println("Min:\t\t"+temperaturVerlauf.getMinTemperatureObject());
        System.out.println("Max:\t\t"+temperaturVerlauf.getMaxTemperatureObject());


        LOG.debug("Programm exited");
    }

}
