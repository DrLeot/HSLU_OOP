import java.util.Objects;

public class Person implements Comparable<Person>{
    private final long ID;
    private String lastName;
    private String firstName;

    public Person(long ID, String lastName, String firstName){

        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
    }


    public long getUUID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString(){
        return ID+": "+firstName+" "+lastName;
    }

    @Override
    public boolean equals(final Object object){
        if(object == this){
            return true;
        }
        if(!(object instanceof Person)){
            return false;
        }
        final Person castedPerson = (Person) object;
        return (castedPerson.ID == this.ID)
                && (castedPerson.firstName.equals(this.firstName))
                && (castedPerson.lastName.equals(this.lastName));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.ID,this.firstName,this.lastName);
    }

    /**
     * Compares this peson with the parameter person
     * @param person person to compare the ID with
     * @return 0 means equals value, -1 less than, 1 greater than
     *
     */
    @Override
    public int compareTo(Person person) {
        return Long.compare(this.ID,person.getUUID());
    }
}
