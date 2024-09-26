package proekt.cars.abstract_cars;

import proekt.cars.car_components.*;
import proekt.factory.Country;
import java.math.BigDecimal;

public abstract class Cabriolet extends Car {
    protected boolean roofClose;

    public Cabriolet(CarModel carModel, Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                     boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                     Electric electric, Headlight headlight, boolean roofClose) {
        super(carModel, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight);
        this.roofClose = roofClose;
    }

    public void roofChange() {
        roofClose = !roofClose;
        System.out.println("Крыша " + (roofClose ? "поднята" : "опущена"));
    }
}