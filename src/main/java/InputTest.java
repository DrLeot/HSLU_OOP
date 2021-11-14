import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class InputTest {

    private static final Logger LOG = LogManager.getLogger(InputTest.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOG.debug("Startup of InputTest");
        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();

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
        LOG.debug("Programm exited");
        System.out.println("Programm beendet.");
    }

}
