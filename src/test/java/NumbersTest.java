import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    private Numbers Numbers;
    @BeforeEach
    public void setUp(){
        Numbers = new Numbers();
    }

    @Test
    public void TestRoman2Int(){
        assertEquals(4,Numbers.romandtointeger("IV"),"should be 4");
        assertEquals(5000,Numbers.romandtointeger("MMMMM"),"should be 5000");
        assertEquals(2008,Numbers.romandtointeger("MMVIII"),"should be 2008");
        assertEquals(99,Numbers.romandtointeger("XCIX"),"should be 99");
        assertEquals(47,Numbers.romandtointeger("XLVII"),"should be 47");
        assertEquals(1990,Numbers.romandtointeger("MCMXC"),"should be 1990");
    }

    @Test
    public void TestRoman(){
        assertEquals("I",Numbers.Converttoroman(1));
        assertEquals("II",Numbers.Converttoroman(2));
        assertEquals("IV",Numbers.Converttoroman(4));
        assertEquals("VIII",Numbers.Converttoroman(8));
        assertEquals("XVI",Numbers.Converttoroman(16));
        assertEquals("XXXII",Numbers.Converttoroman(32));
        assertEquals("MXXIV",Numbers.Converttoroman(1024));
        assertEquals("MMXLVIII",Numbers.Converttoroman(2048));
    }

    @Test
    public void testsimplemax(){
        assertEquals(10,Numbers.max(1,10),"should be 10");
        assertEquals(10, Numbers.max(1,5,10), "should be 10");
    }
    @Test
    public void testerrormax(){
        final ArrayList<Integer> testnumbers = new ArrayList<Integer>();
        assertEquals(0,Numbers.maxnth(testnumbers),"should be 0");
    }

    @Test
    public void testcomplexmax(){
        final ArrayList<Integer> testnumbers = new ArrayList<Integer>();
        testnumbers.add(1);
        testnumbers.add(1);
        testnumbers.add(4);
        testnumbers.add(5);
        testnumbers.add(10);
        assertEquals(10,Numbers.maxnth(testnumbers),"should be 10");
    }

    @Test
    public void testsimplemin(){
        assertEquals(7, Numbers.min(7,10),"should be 7");
    }

    @Test
    public void testnegativemax(){
        assertEquals(3,Numbers.max(-10,3), "should be 3");
    }

    @Test
    public void testnegativemin(){
        assertEquals(-10,Numbers.min(4,-10),"should be -10");
    }
}