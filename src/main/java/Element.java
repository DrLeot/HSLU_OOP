public class Element extends Temperature {
    private String name;
    private float temperatureFluid;
    private float temperatureGas;

    public Element(String name, float temperatureFluid, float temperatureGas){
        super(); // Super-constructor
        this.temperatureFluid = temperatureFluid;
        this.temperatureGas = temperatureGas;
    }

    public String getAggregate(){
        if(super.getTempcelsius() >= temperatureGas){
            return "Gasförmig";
        }
        if(super.getTempcelsius() <= temperatureFluid){
            return "Fest";
        }
        return "Flüssig";
    }
}
