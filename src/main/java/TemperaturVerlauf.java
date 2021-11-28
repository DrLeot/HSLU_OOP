import java.util.*;

public class TemperaturVerlauf {

    private final List<Measurement> measurements = new ArrayList<>();
    private final List<TemperatureValueListener> minmaxListeners = new ArrayList<>();

    /***
     * adds a measurement to the list of temperatures
     * @param measurement new measurement value
     * @return success yes(true)/no(false)
     */
    public boolean add(Measurement measurement){

        boolean success = measurements.add(measurement);

        if(getMaxTemperatureObject() == measurement){
            this.fireMinMaxChangeEvent(new TemperatureMaxEvent(this, measurement, TemperatureMinMax.MAX));
        }
        if(getMinTemperatureObject() == measurement){
            this.fireMinMaxChangeEvent(new TemperatureMaxEvent(this, measurement, TemperatureMinMax.MIN));
        }

        return success;
    }

    public void addPropertyChangeListener(final TemperatureValueListener listener){
        minmaxListeners.add(listener);
    }

    public void removeAllPropertyChangeListener(){
        minmaxListeners.clear();
    }

    private void fireMinMaxChangeEvent(final TemperatureMaxEvent pcEvent){
        for(final TemperatureValueListener listener : minmaxListeners){
            listener.MaxMinChange(pcEvent);
        }
    }


    /***
     * removes a temperature object from the list of temperatures it is listed.
     * @param temperature object to get removed
     * @return success yes(true) / no(false)
     */
    public boolean remove(Temperature temperature){
        return measurements.remove(temperature);
    }

    public void clear(){
        measurements.clear();
    }

    public int getCount(){
        return measurements.size();
    }

    public Measurement getMaxTemperatureObject(){
        return Collections.max(measurements);
    }

    public Measurement getMinTemperatureObject(){
        return Collections.min(measurements);
    }

    /***
     * Loops over all temperatures and sums their temperature.
     * @return Sum of all Temperatures in Kelvin
     */
    public Temperature getSumTemperatureValues(){
        float sum = 0f;
        for(Measurement temperature: measurements){
            sum = sum + temperature.getTemperature().getKelvin();
        }
        return Temperature.createFromKelvin(sum);
    }

    /***
     * Returns the average of all Temperatures listed in Arraylist temperatures.
     * @return Average value in Kelvin
     */
    public Temperature getAvgTemperatureObject(){
        return Temperature.createFromKelvin(getSumTemperatureValues().getKelvin()/getCount());
    }


    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (Measurement temp: measurements) {
            ret.append(temp.toString()).append(";");
        }
        return ret.toString();
    }
}
