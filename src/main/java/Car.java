public class Car {
    private Light frontLightLeft;
    private Light frontLightRight;
    private Light backLightRight;
    private Light backLightLeft;

    public Car(){
        frontLightLeft = new Light();
        frontLightRight = new Light();
        backLightRight = new Light();
        backLightLeft = new Light();
    }

    public void setEmergency(){
        frontLightLeft.switchOn();
        frontLightRight.switchOn();
        backLightRight.switchOn();
        backLightLeft.switchOn();
    }
}
