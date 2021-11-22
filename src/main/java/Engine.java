import java.util.ArrayList;
import java.util.List;

public class Engine implements Switchable {
    private CarObjectState status = CarObjectState.OFF;
    private int rpm = 0;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    @Override
    public void switchOn() {
        status = CarObjectState.ON;
        setRpm(1000);

        this.firePropertyChangeEvent(new PropertyChangeEvent(this,
                "status", CarObjectState.OFF, CarObjectState.ON));
    }

    @Override
    public void switchOff() {
        status = CarObjectState.OFF;
        setRpm(0);

        this.firePropertyChangeEvent(new PropertyChangeEvent(this,
                "status", CarObjectState.ON, CarObjectState.OFF));
    }

    @Override
    public boolean isSwitchedOn() {
        return status == CarObjectState.ON;
    }

    @Override
    public String toString(){
        return "Engine";
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm){
        if(rpm > 0){
            this.rpm = rpm;
        }
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
