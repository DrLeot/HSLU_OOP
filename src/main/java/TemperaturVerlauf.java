import java.util.*;

public class TemperaturVerlauf {

    private List<Temperature> temperatures = new ArrayList<>();
    //private Set<Temperature> temperatures = new HashSet<>();

    public boolean add(Temperature temperature){
        return temperatures.add(temperature);
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

    public float getSumTemperatureValues(){
        float ret = 0f;
        for(Temperature temperature:temperatures){
            ret += temperature.getKelvin();
        }
        return ret;
    }

    public float getAvgTemperatureValue(){
        // Hint: Unfortunately, Collection do not support a average method. Stream-API is not yet discussed so we
        // do it the 'old way' here
        // AVG: sum of all values divided by count of values

        return getSumTemperatureValues()/getCount();
    }

    @Override
    public String toString(){
        String ret = "";
        for (Temperature temp:temperatures) {
            ret += temp.toString() + ";";
        }
        return ret;
    }

}
