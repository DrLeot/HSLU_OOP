import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Light implements Switchable{
    private CarObjectState status = CarObjectState.OFF;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    @Override
    public void switchOn() {
        CarObjectState oldstatus = status;

        // to simulate failurs, a 40% chance of switching on not working may occur
        if(new Random().nextInt((10 - 1) + 1) + 1 <= 4){
            status = CarObjectState.FAILURE;
        }else{
            status = CarObjectState.ON;
        }

        this.firePropertyChangeEvent(new PropertyChangeEvent(this,
                "status", oldstatus, status));

    }

    @Override
    public void switchOff() {
        status = CarObjectState.OFF;
        this.firePropertyChangeEvent(new PropertyChangeEvent(this,
                "status", CarObjectState.ON, CarObjectState.OFF));

    }

    @Override
    public boolean isSwitchedOn() {
        return status == CarObjectState.ON;
    }

    @Override
    public String toString(){
        return "light";
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener){
        changeListeners.add(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener){
        changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent){
        for(final PropertyChangeListener listener : changeListeners){
            listener.propertyChange(pcEvent);
        }
    }
}
