import java.util.EventObject;

public class TemperatureMaxEvent extends EventObject{

    private Object newMax;
    private TemperatureMinMax type;

    public TemperatureMaxEvent(Object source, Object newMax, TemperatureMinMax type) {
        super(source);
        this.newMax = newMax;
        this.type = type;

    }

    public Object getNewMax() {
        return newMax;
    }

    public TemperatureMinMax getType() {
        return type;
    }
}
