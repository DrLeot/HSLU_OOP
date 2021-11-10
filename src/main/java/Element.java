public abstract class Element {


    private final String name;
    private final String symbole;
    private int numberOfProtons;
    private Temperature temperature;
    public Temperature boilingTemperature;
    public Temperature meltingTemperature;


    public Element(String name, int numberOfProtons, String symbole, Temperature temperature,
                   Temperature boilingTemperature, Temperature meltingTemperature) {

        this.name = name;
        this.numberOfProtons = numberOfProtons;
        this.symbole = symbole;
        this.temperature = temperature;
        this.boilingTemperature = boilingTemperature;
        this.meltingTemperature = meltingTemperature;
    }

    public Aggregationstates getAggregate() {
        if (temperature.getCelsius() >= boilingTemperature.getCelsius()) {
            return Aggregationstates.GAS;
        } else if (temperature.getCelsius() >= meltingTemperature.getCelsius()) {
            return Aggregationstates.LIQUID;
        }
        return Aggregationstates.SOLID;
    }


    public String getName() {
        return name;
    }

    public int getNumberOfProtons() {
        return numberOfProtons;
    }

    public String getSymbole() {
        return symbole;
    }

    public abstract String light();

    @Override
    public String toString() {
        // OLD WAY
        /*switch (getAggregate()){
            case GAS:
                text += " gasförmig";
                break;
            case SOLID:
                text += " fest";
                break;
            case LIQUID:
                text += " flüssig";
                break;
        }*/
        // NEW WAY
        return getName() + " ist bei "+temperature.getCelsius()+" Grad "+getAggregate().getState();
    }

}
