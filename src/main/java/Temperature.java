import java.util.Objects;

public final class Temperature implements Comparable<Temperature>{
    private final float KELVIN_DEFAULT = (float) 20;
    public static final float KELVIN_OFFSET = (float) 273.15;

    private float kelvin;

    /***
     * Constructor. Sets the temperature in celsius
     */
    public Temperature(){
        this.kelvin = KELVIN_DEFAULT;
    }
    public Temperature(final float tempvalue){
        this.kelvin = tempvalue;
    }
    public Temperature(Temperature temp){
        this.kelvin = temp.kelvin;
    }

    /** GETTERS **/
    public float getCelsius(){
        return convertKelvinToCelsius(kelvin);
    }
    public float getKelvin(){
        return kelvin;
    }
    public float getTempFahrenheit(){
        return getCelsius() * (float) 1.8 + 32;
    }

    /** SETTER **/
    public void setCelsius(final float celsius){
        this.kelvin = convertCelsiusToKelvin(celsius);
    }
    public void setKelvin(final float kelvin){
        this.kelvin = kelvin;
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
        return Float.compare(this.kelvin,other.kelvin);
    }
}
