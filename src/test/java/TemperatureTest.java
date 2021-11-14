import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    Temperature temp1;

    @BeforeEach
    public void setUp(){
        temp1 = Temperature.createFromKelvin(100);
    }

    @Test
    public void testDefaultValue(){
        assertEquals(20,Temperature.createFromDefault().getKelvin());
    }

    @Test
    public void testFlexibleValue(){
        assertEquals(100,temp1.getKelvin());
    }

    @Test
    public void testCopyTemperatureObject(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromTemperature(a);

        assertEquals(50,b.getKelvin());
    }

    @Test
    public void testZeroKelvinException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Temperature.createFromKelvin(0);
        });
    }

    @Test
    public void testCelsusBelowMinimumException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Temperature.createFromCelsius(-300);
        });
    }

    @Test
    public void testToString(){
        assertTrue(temp1.toString().equals("100.0 K"));
    }

    @Test
    public void testConversionCelsius(){
        assertEquals(-173.15f,temp1.getCelsius());
    }

    @Test
    public void testEquals(){
        Temperature a = Temperature.createFromKelvin(50);
        Temperature b = Temperature.createFromTemperature(a);
        Temperature c = Temperature.createFromDefault();
        Temperature d = null;
        Person e = new Person(1234, "Hans","Gans");

        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertTrue(a.equals(a));
        assertTrue(b.equals(b));

        assertFalse(a.equals(c));
        assertFalse(a.equals(e));
    }

    @Test
    public void testCompare(){
        assertEquals(-1,Temperature.createFromKelvin(50).compareTo(Temperature.createFromKelvin(60)));
        assertEquals(0,Temperature.createFromKelvin(50).compareTo(Temperature.createFromKelvin(50)));
        assertEquals(1,Temperature.createFromKelvin(60).compareTo(Temperature.createFromKelvin(50)));
    }

}
