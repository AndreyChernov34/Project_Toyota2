package proekt.cars;

import proekt.cars.abstract_cars.CarModel;
import proekt.cars.abstract_cars.CargoVan;
import proekt.cars.car_components.*;
import proekt.factory.Country;

import java.math.BigDecimal;

public class Dyna extends CargoVan {

    public Dyna(Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                Electric electric, Headlight headlight, Integer liftingCapacity) {
        super(CarModel.DYNA, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight, liftingCapacity);
    }

    public void chargePhone() {

        System.out.println("Телефон заряжается");
    }
}
