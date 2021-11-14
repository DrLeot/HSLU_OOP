import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

       Temperature a = null;
       try {
           a = Temperature.createFromKelvin(-10);
       } catch (RuntimeException e) {
           e.printStackTrace();
       }

       try {
            a = Temperature.createFromCelsius(-273.15f);
       } catch (RuntimeException e) {
            e.printStackTrace();
       }

    }
}
