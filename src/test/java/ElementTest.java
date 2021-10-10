import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    public Element nitrogen;
    public Element mercury;
    public Element lead;

    @BeforeEach
    public void setup(){
        nitrogen = new Element("N", -210,-196);
        mercury = new Element("Hg", -38.83f,357);
        lead = new Element("Pb", 327.43f,1744);
    }
    @Test
    public void testgas(){
        lead.setTempcelsius(1750);
        assertEquals("Gasförmig",lead.getAggregate());
    }

    @Test
    public void testfluid(){
        mercury.setTempcelsius(0);
        assertEquals("Flüssig",mercury.getAggregate());
    }
    @Test
    public void testsolid(){
        nitrogen.setTempcelsius(-220);
        assertEquals("Fest",nitrogen.getAggregate());
    }
}