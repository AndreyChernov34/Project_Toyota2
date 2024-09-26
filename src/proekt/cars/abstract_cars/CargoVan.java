package proekt.cars.abstract_cars;

import proekt.cars.car_components.*;
import proekt.factory.Country;

import java.math.BigDecimal;

public abstract class CargoVan extends Car {
    protected Integer liftingCapacity;

    public CargoVan(CarModel carModel, Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                    boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                    Electric electric, Headlight headlight, Integer liftingCapacity) {
        super(carModel, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight);
        this.liftingCapacity = liftingCapacity;
    }

    public Integer getLiftingCapacity() {
        return liftingCapacity;
    }
}
