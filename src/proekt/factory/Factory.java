package proekt.factory;

import proekt.cars.car_components.*;

/*
Фабрика компонентов машины
 */

public class Factory {
    public Country country;
    protected static int COUNT_WHEELS = 4;

    public Factory(Country country) {
        this.country = country;
    }

    public Engine createEngine() {
        return new Engine(true);
    }

    public FuelTank createFueltank() {
        return new FuelTank(0);
    }

    public Electric createElectric() {
        return new Electric(true);
    }

    public Headlight createHeadlight() {
        return new Headlight(true);
    }

    public Wheel[] createWeels(WheelDiskEnum wheelDiskEnum) {
        Wheel[] wheels = new Wheel[COUNT_WHEELS];
        for (int i = 0; i < COUNT_WHEELS; i++) {

            wheels[i] = new Wheel(wheelDiskEnum);
        }
        return wheels;
    }

}
