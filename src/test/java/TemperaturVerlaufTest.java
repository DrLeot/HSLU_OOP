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
        Temperature a = new Temperature();
        temperaturVerlauf.add(a);
        assertTrue(temperaturVerlauf.add(a));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void addTemperature(){
        Temperature a = new Temperature();
        Temperature b = new Temperature(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertEquals(2,temperaturVerlauf.getCount());
    }

    @Test
    public void testToString(){
        Temperature a = new Temperature();
        Temperature b = new Temperature(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertTrue(temperaturVerlauf.toString().equals("20.0 K;100.0 K;"));
    }

    @Test
    public void testClear(){
        Temperature a = new Temperature();
        Temperature b = new Temperature(100);
        assertTrue(temperaturVerlauf.add(a));
        assertTrue(temperaturVerlauf.add(b));
        assertEquals(2,temperaturVerlauf.getCount());
        temperaturVerlauf.clear();
        assertEquals(0,temperaturVerlauf.getCount());
    }

    @Test
    public void testMaxObject(){
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(45);
        Temperature c = new Temperature(0);
        Temperature d = new Temperature(70);
        Temperature e = new Temperature(100);
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
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(45);
        Temperature c = new Temperature(0);
        Temperature d = new Temperature(70);
        Temperature e = new Temperature(100);
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
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(45);
        temperaturVerlauf.add(a);
        temperaturVerlauf.add(b);
        assertEquals(95,temperaturVerlauf.getSumTemperatureValues());
    }

    @Test
    public void testAverage(){
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(45);
        temperaturVerlauf.add(a);
        temperaturVerlauf.add(b);

        assertEquals(47.5f,temperaturVerlauf.getAvgTemperatureValue());

    }
}