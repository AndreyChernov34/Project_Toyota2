package proekt.cars.abstract_cars;

import proekt.factory.Country;
import proekt.cars.car_components.*;


import java.math.BigDecimal;
import java.util.Arrays;

public abstract class Car {
    private final CarModel carModel;
    protected Country country;
    protected String color;
    protected Integer maxSpeed;
    protected KppTypeEnum kppTypeEnum;
    protected boolean movement;
    public static final int COUNT_WEELS = 4;
    public Wheel[] wheels;
    protected BigDecimal price;
    public FuelTank fuelTank;
    private Engine engine;
    private Electric electric;
    private Headlight headlight;

    public Car(CarModel carModel, Country country, String color, Integer maxSpeed, KppTypeEnum kppTypeEnum,
               boolean movement, Wheel[] wheels, BigDecimal price, FuelTank fuelTank, Engine engine,
               Electric electric, Headlight headlight) {
        this.carModel = carModel;
        this.country = country;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.kppTypeEnum = kppTypeEnum;
        this.movement = movement;
        this.wheels = wheels;
        this.price = price;
        this.fuelTank = fuelTank;
        this.engine = engine;
        this.electric = electric;
        this.headlight = headlight;

    }

    //замена колеса
    public void wheelchange(Wheel wheel, int number) {
        // проверка на номер колеса и на такой же радиус
        if (number < COUNT_WEELS) {
            if (wheels[number].getWheelDisk().name().equals(wheel.getWheelDisk().name())) {
                this.wheels[number] = wheel;
                System.out.println("колесо заменено");
            } else {
                System.out.println("колесо не подходит по размеру");
            }
        } else {
            System.out.println("порядковый номер колеса в машине неверный");
        }
    }

    public void headlightChange() {
        if (this.headlight.functional) {
            headlight.setLightOn(!headlight.isLightOn());
            if (headlight.isLightOn()) {
                System.out.println("Фары включены");
            } else {
                System.out.println("Фары выключены");
            }
        } else {
            System.out.println("Фары неисправны");
        }
    }

    public void start() throws StartCarException {
        for (Wheel wheel : wheels) {
            if (wheel.isPuncture()) {
                throw new StartCarException("В машине пробито колесо");
            }
            if (wheel == null) {
                throw new StartCarException("В машине нет колеса");
            }
        }

        if (!electric.functional) {
            throw new StartCarException("В машине не работает электрика");
        }

        if (!engine.functional) {
            throw new StartCarException("В машине не работает двигатель");
        }

        if (fuelTank.getFuel() <= 0) {
            throw new StartCarException("В машине нет топлива");
        } else {
            movement = true;
            System.out.println("Машина поехала");
        }

    }

    public void stop() {
        movement = false;
        System.out.println("Машина остановилась");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel=" + carModel +
                ", country=" + country +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", kppTypeEnum=" + kppTypeEnum +
                ", movement=" + movement +
                ", wheels=" + Arrays.toString(wheels) +
                ", price=" + price +
                ", fuelTank=" + fuelTank +
                ", engine=" + engine +
                ", electric=" + electric +
                ", headlight=" + headlight +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public Engine getEngine() {
        return engine;
    }

    public Electric getElectric() {
        return electric;
    }

    public Headlight getHeadlight() {
        return headlight;
    }

    public void setFuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }
}

      