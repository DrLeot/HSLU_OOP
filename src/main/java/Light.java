public class Light implements Switchable{
    private boolean status = false;

    @Override
    public void switchOn() {
        status = true;
    }

    @Override
    public void switchOff() {
        status = false;
    }

    @Override
    public boolean isSwitchedOn() {
        return status;
    }
}
