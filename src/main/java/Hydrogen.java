public class Hydrogen extends Element {
    public Hydrogen(String name, int numberOfProtons, String symbole,
                    Temperature temperature, Temperature boilingtemperature, Temperature meltingtemperature) {

        super(name, numberOfProtons, symbole,
                temperature, boilingtemperature, meltingtemperature);
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
