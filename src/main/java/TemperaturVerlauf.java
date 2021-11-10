import java.util.*;

public class TemperaturVerlauf {

    private List<Temperature> temperatures = new ArrayList<>();

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
        float sum = 0f;
        for(Temperature temperature:temperatures){
            sum += temperature.getKelvin();
        }
        return sum;
    }

    public float getAvgTemperatureValue(){
        return getSumTemperatureValues()/getCount();
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
