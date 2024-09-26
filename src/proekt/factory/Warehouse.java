package proekt.factory;

import proekt.cars.abstract_cars.Car;
import proekt.cars.abstract_cars.CarModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Склад
 */

public class Warehouse {
    private final int capacity = 1000;
    private int countAllCars = 0;
    private Map<CarModel, List<Car>> carMap = new HashMap<>();

    // Добавление авто на склад
    public void addCar(Car car) {
        if (countAllCars < capacity) {
            carMap.computeIfAbsent(car.getCarModel(), k -> new ArrayList<>()).add(car);
            countAllCars++;
        } else {
            System.out.println("склад  заполнен");
        }
    }

    // Изьятие авто из склада

    public Car takeCar(CarModel carModel) {
        if (carMap.containsKey(carModel)) {
            countAllCars--;
            return carMap.get(carModel).remove(0);
        } else {
            System.out.format("модели %s нет на складе\n", carModel);
        }
        return null;
    }

    // подсчет общего количества авто на складе

    public int getCountAllCars() {
        return countAllCars;
    }

    // подсчет количества заданной модели авто на складе

    public int getCountModelCars(CarModel carModel) {
        return carMap.get(carModel).size();
    }
}
