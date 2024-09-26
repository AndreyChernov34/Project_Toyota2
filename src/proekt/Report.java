package proekt;

import proekt.cars.abstract_cars.Car;

import java.util.ArrayList;
import java.util.List;

/*
Отчет менеджера
 */

public class Report {
    public String nameManager;
    List<Car> cars = new ArrayList<>();

    public Report(String nameManager) {
        this.nameManager = nameManager;

    }

    public void addReport(Car car) {
        cars.add(car);
    }
}
