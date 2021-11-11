import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    Temperature temp1;

    @BeforeEach
    public void setUp(){
        temp1 = new Temperature(100);
    }

    @Test
    public void testDefaultValue(){
        assertEquals(20,new Temperature().getKelvin());
    }

    @Test
    public void testFlexibleValue(){
        assertEquals(100,temp1.getKelvin());
    }

    @Test
    public void testCopyTemperatureObject(){
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(a);

        assertEquals(50,b.getKelvin());
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
        Temperature a = new Temperature(50);
        Temperature b = new Temperature(a);
        Temperature c = new Temperature();
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
        assertEquals(-1,new Temperature(50).compareTo(new Temperature(60)));
        assertEquals(0,new Temperature(50).compareTo(new Temperature(50)));
        assertEquals(1,new Temperature(60).compareTo(new Temperature(50)));
    }

}
