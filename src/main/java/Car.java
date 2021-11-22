public class Car implements Switchable{
    private Light frontLightLeft;
    private Light frontLightRight;
    private Light breakLightRight;
    private Light breakLightLeft;
    private Engine engine;

    private Colors color;
    private CarBrands brand;

    private class MotorPropertyListener
            implements PropertyChangeListener {
        @Override
        public void propertyChange(final PropertyChangeEvent event) {
            System.out.println("A:" + event);
        }
    }
    private class LightPropertyListener
            implements PropertyChangeListener {
        @Override
        public void propertyChange(final PropertyChangeEvent event) {
            System.out.println("B: "+event);
        }
    }

    public Car(CarBrands brand, Colors color){
        this.brand = brand;
        this.color = color;

        frontLightLeft = new Light();
        frontLightRight = new Light();
        breakLightRight = new Light();
        breakLightLeft = new Light();
        engine = new Engine();

        engine.addPropertyChangeListener(new Car.MotorPropertyListener());
        frontLightLeft.addPropertyChangeListener(new Car.LightPropertyListener());
        frontLightRight.addPropertyChangeListener(new Car.LightPropertyListener());
        breakLightRight.addPropertyChangeListener(new Car.LightPropertyListener());
        breakLightLeft.addPropertyChangeListener(new Car.LightPropertyListener());

    }

    public String getBrandName() {
        return brand.getCarBrandName();
    }

    public String getColorNAme(){
        return color.getColorname();
    }

    @Override
    public void switchOn() {
        engine.switchOn();
        frontLightRight.switchOn();
        frontLightLeft.switchOn();
    }

    @Override
    public void switchOff() {
        engine.switchOff();
        frontLightRight.switchOff();
        frontLightLeft.switchOff();
    }


    @Override
    public boolean isSwitchedOn() {
        return engine.isSwitchedOn();
    }

    @Override
    public String toString(){
        return "This is our brand new "+getBrandName()+" in astonishing "+getColorNAme();
    }

}
