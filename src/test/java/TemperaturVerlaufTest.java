import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemperaturVerlaufTest {

    TemperaturVerlauf temperaturVerlauf;

    @BeforeEach
    public void setUp(){
        temperaturVerlauf = new TemperaturVerlauf();
    }

    @Test
    public void addDuplicate(){
        Temperature a = Temperature.createFromDefault();
        temperaturVerlauf.add(new Measurement(a, LocalDateTime.now()));
        temperaturVerlauf.add(new Measurement(a, LocalDateTime.now()));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void addTemperature(){
        Temperature a = Temperature.createFromDefault();
        Temperature b = Temperature.createFromKelvin(100);
        temperaturVerlauf.add(new Measurement(a, LocalDateTime.now()));
        temperaturVerlauf.add(new Measurement(b, LocalDateTime.now()));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void testClear(){
        Temperature a = Temperature.createFromDefault();
        Temperature b = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(new Measurement(a)));
        assertTrue(temperaturVerlauf.add(new Measurement(b)));
        assertEquals(2,temperaturVerlauf.getCount());
        temperaturVerlauf.clear();
        assertEquals(0,temperaturVerlauf.getCount());
    }

    @Test
    public void testMaxObject(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        Temperature c = Temperature.createFromKelvin(0);
        Temperature d = Temperature.createFromKelvin(70);
        Temperature e = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(new Measurement(a)));
        assertTrue(temperaturVerlauf.add(new Measurement(b)));
        assertTrue(temperaturVerlauf.add(new Measurement(c)));
        assertTrue(temperaturVerlauf.add(new Measurement(d)));
        assertTrue(temperaturVerlauf.add(new Measurement(e)));
        assertTrue(temperaturVerlauf.add(new Measurement(b)));


        assertTrue(temperaturVerlauf.getMaxTemperatureObject().getTemperature().equals(e));
    }

    @Test
    public void testMinObject(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        Temperature c = Temperature.createFromKelvin(0);
        Temperature d = Temperature.createFromKelvin(70);
        Temperature e = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(new Measurement(a)));
        assertTrue(temperaturVerlauf.add(new Measurement(b)));
        assertTrue(temperaturVerlauf.add(new Measurement(c)));
        assertTrue(temperaturVerlauf.add(new Measurement(d)));
        assertTrue(temperaturVerlauf.add(new Measurement(e)));
        assertTrue(temperaturVerlauf.add(new Measurement(b)));


        assertTrue(temperaturVerlauf.getMinTemperatureObject().getTemperature().equals(c));
    }

    @Test
    public void testSum(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        temperaturVerlauf.add(new Measurement(a));
        temperaturVerlauf.add(new Measurement(b));
        assertEquals(95,temperaturVerlauf.getSumTemperatureValues().getKelvin());
    }

    @Test
    public void testAverage(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        temperaturVerlauf.add(new Measurement(a));
        temperaturVerlauf.add(new Measurement(b));
        assertEquals(47.5f,temperaturVerlauf.getAvgTemperatureObject().getKelvin());
    }
}