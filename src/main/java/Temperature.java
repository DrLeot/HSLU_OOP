import java.util.Objects;

public final class Temperature implements Comparable<Temperature>{

    public enum Temperatureunits {
        KELVIN, CELSIUS
    }

    public static final float KELVIN_OFFSET = (float) 273.15;
    public final float KELVIN_DEFAULT = (float) 20;

    private float kelvin;


    /***
     * Sets the temperature to the default value (20) in Kelvin
     */
    private Temperature(){
        this.kelvin = KELVIN_DEFAULT;
    }
    /***
     * Sets the temperature in kelvin
     * @param tempvalue temperature value in Kelvin
     */
    private Temperature(final float tempvalue, final Temperatureunits unit){
        switch (unit){
            case KELVIN:
                this.kelvin = tempvalue;
                break;
            case CELSIUS:
                this.kelvin = convertCelsiusToKelvin(tempvalue);
                break;
        }
    }

    /***
     * sets the temperature in kelvin by calling another constructor
     * @param temperature temperature object to get the kelvin value from
     */
    private Temperature(Temperature temperature){
        this(temperature.getKelvin(),Temperatureunits.KELVIN);
    }

    public static Temperature createFromCelsius(final float celsius) throws IllegalArgumentException{
        if(celsius < -273.15f){
            throw new IllegalArgumentException("Celsius cannot be less than minimum of -273.15");
        }

        return new Temperature(celsius,Temperatureunits.KELVIN);
    }

    public static Temperature createFromKelvin(final float kelvin) throws IllegalArgumentException{
        if(kelvin < 0){
           throw new IllegalArgumentException("Kelvin cannot be less than zero");
        }

        return new Temperature(kelvin,Temperatureunits.KELVIN);
    }

    public static Temperature createFromTemperature(final Temperature temperature){
        return new Temperature(temperature);
    }

    public static Temperature createFromDefault(){
        return new Temperature();
    }


    /** GETTERS **/
    public float getKelvin(){
        return this.kelvin;
    }
    public float getCelsius(){
        return convertKelvinToCelsius(kelvin);
    }



    public static float convertKelvinToCelsius(float kelvin){
        return kelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin(float celsius){
        return celsius + KELVIN_OFFSET;
    }

    @Override
    public String toString(){
        return kelvin + " K";
    }

    @Override
    public boolean equals(final Object object){
        if(object == this){
            return true;
        }
        if(!(object instanceof Temperature)){
            return false;
        }
        final Temperature castedTemperature = (Temperature) object;
        return (castedTemperature.kelvin == this.kelvin);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.kelvin);
    }

    @Override
    public int compareTo(Temperature other){
        return Float.compare(this.kelvin, other.kelvin);
    }

}
