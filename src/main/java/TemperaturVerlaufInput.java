import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TemperaturVerlaufInput {

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlaufInput.class);

    private static class MinMaxValueListener
            implements TemperatureValueListener {
        @Override
        public void MaxMinChange(TemperatureMaxEvent event) {
            System.out.println("New "+ event.getType().getName() +" value entered");
        }
    }

    public static void main(String[] args) {
        LOG.debug("Startup of InputTest");
        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.addPropertyChangeListener(new TemperaturVerlaufInput.MinMaxValueListener());

        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            LOG.info("User entered: " + input);
            try{
                float value = Float.valueOf(input);
                temperaturVerlauf.add(Temperature.createFromKelvin(value));
                LOG.info("Converted to: " +temperaturVerlauf.toString());
            }catch (NumberFormatException ex){
                LOG.error(ex);
            }catch (IllegalArgumentException ex){
                LOG.error(ex);
            }
        } while (!input.equals("exit"));
        temperaturVerlauf.removeAllPropertyChangeListener(); // cleanup
        System.out.println("Programm wird beendet. Statistik:");
        System.out.println("Anzahl Werte:\t\t"+temperaturVerlauf.getCount());
        System.out.println("Durchschnitt:\t\t"+temperaturVerlauf.getAvgTemperatureValue());
        System.out.println("Min:\t\t"+temperaturVerlauf.getMinTemperatureObject());
        System.out.println("Max:\t\t"+temperaturVerlauf.getMaxTemperatureObject());


        LOG.debug("Programm exited");
    }

}
