package proekt.cars;

import proekt.cars.abstract_cars.CarModel;
import proekt.cars.car_components.*;
import proekt.cars.abstract_cars.Cabriolet;
import proekt.factory.Country;

import java.math.BigDecimal;

public class Solara extends Cabriolet {
    public Solara(Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                  boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                  Electric electric, Headlight headlight, boolean roofClose) {
        super(CarModel.SOLARA, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight, roofClose);
    }

    public void freeze() {

        System.out.println("Холодильник охлаждает");
    }
}

