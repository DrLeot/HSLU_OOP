public class Engine implements Switchable {
    private boolean status = false;
    private int rpm = 0;

    @Override
    public void switchOn() {
        status = true;
        setRpm(1000);
    }

    @Override
    public void switchOff() {
        status = false;
        setRpm(0);
    }

    @Override
    public boolean isSwitchedOn() {
        return status;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm){
        if(rpm < 0 || rpm > 6500){
            return;
        }
        this.rpm = rpm;
    }
}
