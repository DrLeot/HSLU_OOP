import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        temperaturVerlauf.add(a);
        assertTrue(temperaturVerlauf.add(a));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void addTemperature(){
        Temperature a = Temperature.createFromDefault();
        Temperature b = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void testToString(){
        Temperature a = Temperature.createFromDefault();
        Temperature b = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertTrue(temperaturVerlauf.toString().equals("20.0 K;100.0 K;"));
    }

    @Test
    public void testClear(){
        Temperature a = Temperature.createFromDefault();
        Temperature b = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
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
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertTrue(temperaturVerlauf.add(c));
        assertTrue(temperaturVerlauf.add(d));
        assertTrue(temperaturVerlauf.add(e));
        assertTrue(temperaturVerlauf.add(b));


        assertTrue(temperaturVerlauf.getMaxTemperatureObject().equals(e));
    }

    @Test
    public void testMinObject(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        Temperature c = Temperature.createFromKelvin(0);
        Temperature d = Temperature.createFromKelvin(70);
        Temperature e = Temperature.createFromKelvin(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertTrue(temperaturVerlauf.add(c));
        assertTrue(temperaturVerlauf.add(d));
        assertTrue(temperaturVerlauf.add(e));
        assertTrue(temperaturVerlauf.add(b));


        assertTrue(temperaturVerlauf.getMinTemperatureObject().equals(c));
    }

    @Test
    public void testSum(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        temperaturVerlauf.add(a);
        temperaturVerlauf.add(b);
        assertEquals(95,temperaturVerlauf.getSumTemperatureValues());
    }

    @Test
    public void testAverage(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromKelvin(45);
        temperaturVerlauf.add(a);
        temperaturVerlauf.add(b);

        assertEquals(47.5f,temperaturVerlauf.getAvgTemperatureValue());

    }
}