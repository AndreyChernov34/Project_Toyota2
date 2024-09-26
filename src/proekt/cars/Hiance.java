package proekt.cars;

import proekt.cars.abstract_cars.CarModel;
import proekt.cars.car_components.*;
import proekt.cars.abstract_cars.CargoVan;
import proekt.factory.Country;

import java.math.BigDecimal;

public class Hiance extends CargoVan {
    private Wheel spareWheel;

    public Hiance(Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
                  boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
                  Electric electric, Headlight headlight, Integer liftingCapacity, Wheel spareWheel) {
        super(CarModel.HIANCE, country, color, maxSpeed, kppTypeEnum, movement, wheels, price, fuelTank, engine,
                electric, headlight, liftingCapacity);
        this.spareWheel = spareWheel;
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel newspareWheel) {
        if (newspareWheel.getWheelDisk().name().equals(CarModel.HIANCE.getWheelDiskEnum())) {
            this.spareWheel = newspareWheel;
        } else {
            System.out.println("Диск колеса не подходит, требуется " + CarModel.HIANCE.getWheelDiskEnum());
        }

    }
}
