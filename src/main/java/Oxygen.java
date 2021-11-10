public class Oxygen extends Element {
    public Oxygen(String name, int numberOfProtons, String symbole,
                  Temperature temperature,Temperature boilingtemperature, Temperature meltingtemperature) {

        super(name, numberOfProtons, symbole,
                temperature, boilingtemperature, meltingtemperature);
    }

    @Override
    public String light(){
        return "Nothing happens";
    }
}
