import java.util.Comparator;

public class PersonSortbyFirstname implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getFirstName().compareTo(b.getFirstName());
    }

}
