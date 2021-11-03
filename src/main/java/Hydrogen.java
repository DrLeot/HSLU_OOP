public class Hydrogen extends Element2{
    public Hydrogen(String name, int numberOfProtons, String symbole) {
        super(name, numberOfProtons, symbole);
    }

    @Override
    public String light(){
        return "boom";
    }

    @Override
    public String toString(){
        return super.toString() + " GIFTIG!";
    }
}
