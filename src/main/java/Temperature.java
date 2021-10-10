public class Temperature {
    final float CELSIUS_OFFSET = (float) 273.15;
    private float tempcelsius;

    /***
     * Constructor. Sets the temperature in celsius
     */
    public Temperature(){
        this.tempcelsius = 20;
    }
    public Temperature(final float tempvalue){
        this.tempcelsius = tempvalue;
    }

    /** GETTERS **/
    public float getTempcelsius(){
        return this.tempcelsius;
    }
    public float getTempkelvin(){
        return this.tempcelsius + CELSIUS_OFFSET;
    }
    public float getTempFahrenheit(){
        return this.tempcelsius * (float) 1.8 + 32;
    }


    public void setTempcelsius(final float tempcelsius){
        this.tempcelsius = tempcelsius;
    }
    public void adjustTempcelsius(final float difference){
        this.tempcelsius += difference;
    }

}
