import java.time.LocalDateTime;
import java.util.Objects;

public class Measurement implements Comparable<Measurement> {
    private Temperature temperature;
    private LocalDateTime dateTime;

    public Measurement(Temperature temperature){
        this.temperature = temperature;
        this.dateTime = LocalDateTime.now();
    }
    public Measurement(Temperature temperature, LocalDateTime dateTime){
        this.temperature = temperature;
        this.dateTime = dateTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Temperature)) {
            return false;
        }
        final Measurement other = (Measurement) object;
        return Float.compare(other.temperature.getKelvin(), this.temperature.getKelvin()) == 0 && this.dateTime.equals(other.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.temperature.getKelvin() +this.dateTime.toString());
    }

    @Override
    public int compareTo(Measurement other) {
        return Float.compare(this.temperature.getKelvin(), other.temperature.getKelvin());
    }

    @Override
    public String toString(){
        return getDateTime()+": "+temperature.toString();
    }
}