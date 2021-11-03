import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private ArrayList<Person> persons = new ArrayList<Person>();

    @BeforeEach
    public void setUp(){
        persons.add(new Person(1234,"Lustig","Hans"));
        persons.add(new Person(1234,"Lustig","Hans"));
        persons.add(new Person(5678,"Lustig","Hans"));

    }

    @Test
    public void testPersongetter(){
        assertEquals(1234, persons.get(0).getUUID());
        assertEquals("Hans",persons.get(0).getFirstName());
        assertEquals("Lustig",persons.get(0).getLastName());
    }

    @Test
    public void testToString(){
        assertEquals("1234: Hans Lustig", persons.get(0).toString());
    }

    @Test
    public void testEqualsSameObject(){
        assertTrue(persons.get(0).equals(persons.get(0)));
        assertTrue(persons.get(0).equals(persons.get(1)));
    }
    @Test
    public void testEqualsWithDifferentID(){
        assertTrue(!(persons.get(0).equals(persons.get(2))));
    }
    @Test
    public void testHashCode(){
        assertTrue(persons.get(0).hashCode() == persons.get(1).hashCode());
    }
    @Test
    public void testCompareTo(){
        assertTrue(persons.get(0).compareTo(persons.get(1)) == 0);
    }


}