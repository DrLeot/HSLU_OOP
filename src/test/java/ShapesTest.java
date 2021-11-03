import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapesTest {

    private Shape circle;
    private Shape square;
    private Shape rect;

    @BeforeEach
    public void setUp(){

        circle = new Circle(10,10,5);
        square = new Square(10,10,7);
        rect = new Rectangle(5,5,7,8);
    }

    @Test
    public void testAreas(){
        assertEquals(12,circle.getArea());
        assertEquals(49,square.getArea());
        assertEquals(56,rect.getArea());
    }

    @Test
    public void testPerimeters(){
        assertEquals(15,circle.getPerimeter());
        assertEquals(7*4,square.getPerimeter());
        assertEquals(30,rect.getPerimeter());
    }
}
