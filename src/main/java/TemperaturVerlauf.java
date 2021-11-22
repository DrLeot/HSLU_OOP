import java.util.*;

public class TemperaturVerlauf {

    private List<Temperature> temperatures = new ArrayList<>();
    private final List<TemperatureValueListener> minmaxListeners = new ArrayList<>();

    /***
     * adds a temperature to the list of temperatures
     * @param temperature new temperature value
     * @return success yes(true)/no(false)
     */
    public boolean add(Temperature temperature){
        boolean success = temperatures.add(temperature);

        if(getMaxTemperatureObject() == temperature){
            this.fireMinMaxChangeEvent(new TemperatureMaxEvent(this, temperature, TemperatureMinMax.MAX));
        }
        if(getMinTemperatureObject() == temperature){
            this.fireMinMaxChangeEvent(new TemperatureMaxEvent(this, temperature, TemperatureMinMax.MIN));
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
        return temperatures.remove(temperature);
    }

    public void clear(){
        temperatures.clear();
    }

    public int getCount(){
        return temperatures.size();
    }

    public Temperature getMaxTemperatureObject(){
        return Collections.max(temperatures);
    }

    public Temperature getMinTemperatureObject(){
        return Collections.min(temperatures);
    }

    /***
     * Loops over all temperatures and sums their temperature.
     * @return Sum of all Temperatures in Kelvin
     */
    public Temperature getSumTemperatureValues(){
        float sum = 0f;
        for(Temperature temperature:temperatures){
            sum += temperature.getKelvin();
        }
        return Temperature.createFromKelvin(sum);
    }

    /***
     * Expert Level:
     * Returns the sum of all Temperatures listed in temperatures over streamAPI method.
     * @return Sum of all Temperatures in Kelvin
     */
    public float getSumTemperatureValuesoverStream(){
        return (float) temperatures.stream().mapToDouble(Temperature::getKelvin).sum();
    }

    /***
     * Returns the average of all Temperatures listed in Arraylist temperatures.
     * @return Average value in Kelvin
     */
    public Temperature getAvgTemperatureValue(){
        return Temperature.createFromKelvin(getSumTemperatureValues().getKelvin()/getCount());
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (Temperature temp:temperatures) {
            ret.append(temp.toString()).append(";");
        }
        return ret.toString();
    }
}
