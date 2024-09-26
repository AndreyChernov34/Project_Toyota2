package proekt.cars.car_components;

public class Headlight extends Components {
    private boolean lightOn;

    public Headlight(boolean functional) {
        super(functional);
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }
}
