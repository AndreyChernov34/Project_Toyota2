package proekt.cars;

import proekt.cars.abstract_cars.CarModel;
import proekt.cars.abstract_cars.LightCar;
import proekt.cars.car_components.*;
import proekt.factory.Country;

import java.math.BigDecimal;

public class Camry extends LightCar {

    public Camry(Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                 boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                 Electric electric, Headlight headlight, boolean cruizeControl) {
        super(CarModel.CAMRY, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight, cruizeControl);
    }

    public void usb() {
        System.out.println("Подключаем музыку");
    }
}
