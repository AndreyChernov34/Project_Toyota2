package proekt.cars.abstract_cars;

import proekt.cars.car_components.*;
import proekt.factory.Country;

import java.math.BigDecimal;

public abstract class LightCar extends Car {
    protected boolean cruizeControl;

    public LightCar(CarModel carModel, Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                    boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                    Electric electric, Headlight headlight, boolean cruizeControl) {
        super(carModel, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight);
        this.cruizeControl = cruizeControl;
    }

    public void cruizeChange() {
        cruizeControl = !cruizeControl;
        System.out.println("Круизконтроль " + (cruizeControl ? "включен" : "выключен"));
    }

}
