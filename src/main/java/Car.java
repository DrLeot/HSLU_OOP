import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car implements Switchable{
    private Light frontLightLeft;
    private Light frontLightRight;
    private Light breakLightRight;
    private Light breakLightLeft;
    private Engine engine;

    private Colors color;
    private CarBrands brand;
    private static final Logger LOG = LogManager.getLogger(Car.class);

    public Car(CarBrands brand, Colors color){
        this.brand = brand;
        this.color = color;

        frontLightLeft = new Light();
        frontLightRight = new Light();
        breakLightRight = new Light();
        breakLightLeft = new Light();
        engine = new Engine();

        engine.addPropertyChangeListener(LOG::info);
        frontLightLeft.addPropertyChangeListener(LOG::info);
        frontLightRight.addPropertyChangeListener(LOG::info);
        breakLightRight.addPropertyChangeListener(LOG::info);
        breakLightLeft.addPropertyChangeListener(LOG::info);

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
