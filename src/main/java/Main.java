import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        /*
        * We are going to create some persons which are not yet sorted by ID.
        * with our overriden compareTo() method in Person, the Arraylist gets sorted automatically
        * */
        ArrayList<Person> Persons = new ArrayList<Person>();
        Persons.add(new Person(1,"Aben","Theodore"));
        Persons.add(new Person(8,"Betty","Cesar"));
        Persons.add(new Person(4,"Annen","Gustav"));
        Persons.add(new Person(7,"Barmettler","Lenny"));
        Persons.add(new Person(3,"Wey","Laron"));

        System.out.println(Persons); // unsorted
        // Calls all Person-objects's compareTo() method and sorts them
        // As the method "sort" automatically access compareTo() method, we have to implement it
        Collections.sort(Persons);
        System.out.println(Persons); // sorted

        Collections.shuffle(Persons); // randomly shuffling it again

        System.out.println(Persons); // unsorted
        // calls the tiny sortbyFirstname Class which lets us sort by firstname
        // this is useful when you have multiple sorting method to provide and we can only implement 1 compareTo() method..
        Collections.sort(Persons, new PersonSortbyFirstname());
        System.out.println(Persons); // sorted by first name

    }
}
