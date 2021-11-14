import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {


    @Test
    public void testHydrogenliquid(){
        Hydrogen hydro = new Hydrogen("Wasserstoff",1,"H",
                Temperature.createFromKelvin(100), // current temp
                Temperature.createFromKelvin(120), // boiling
                Temperature.createFromKelvin(60)); // melting

        assertEquals(Aggregationstates.LIQUID,hydro.getAggregate());
    }
    @Test
    public void testHydrogengas(){
        Hydrogen hydro = new Hydrogen("Wasserstoff",1,"H",
                Temperature.createFromKelvin(130), // current temp
                Temperature.createFromKelvin(120), // boiling
                Temperature.createFromKelvin(60)); // melting

        assertEquals(Aggregationstates.GAS,hydro.getAggregate());
    }
    @Test
    public void testHydrogensolid(){
        Hydrogen hydro = new Hydrogen("Wasserstoff",1,"H",
                Temperature.createFromKelvin(10), // current temp
                Temperature.createFromKelvin(120), // boiling
                Temperature.createFromKelvin(60)); // melting

        assertEquals(Aggregationstates.SOLID,hydro.getAggregate());
    }
    @Test
    public void testToStringSolid(){
        Oxygen oxygen = new Oxygen("Wasserstoff",1,"H",
                Temperature.createFromKelvin(10), // current temp
                Temperature.createFromKelvin(120), // boiling
                Temperature.createFromKelvin(60)); // melting

        assertEquals("Wasserstoff ist bei -263.15 Grad Fest",oxygen.toString());
    }

}