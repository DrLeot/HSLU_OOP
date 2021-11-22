import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car1;

    @BeforeEach
    public void setUp(){
        car1 = new Car(CarBrands.BMW,Colors.BLUE);
    }

    @Test
    public void testCarToString(){
        assertEquals(car1.toString(),"This is our brand new BMW in astonishing Blau");
    }
}