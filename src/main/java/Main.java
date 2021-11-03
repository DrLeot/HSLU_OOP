import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> Persons = new ArrayList<Person>();
        Persons.add(new Person(1234,"Hans","Jucker"));
        Persons.add(new Person(5678,"Hans","Maier"));
        Persons.add(new Person(1111,"Lisa","Barmettler"));

        Person d = new Person(1111,"Lisa","Barmettler");

        for (Person person : Persons){
            if(d.getUUID() == person.getUUID()){
                System.out.println("Diese Person existiert bereits");
                return;
            }
            Persons.add(d);
            //person.compareTo(d);
        }

        /*Shape shape1 = new Circle(1,1,5);
        Circle circl1 = new Circle(1,2,10);

        Shape shape2 = new Rectangle(1,1,5,5);

        System.out.println(((Circle) shape1).getDiameter());*/
    }
}
