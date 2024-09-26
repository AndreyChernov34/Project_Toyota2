package proekt;

import proekt.cars.abstract_cars.Car;

import java.math.BigDecimal;
/*
Кассир
 */

public class Cashier {
    //Общий список продаж для всех кассиров

    public static BigDecimal check;

    //получение оплаты

    public void recievePayment(Car car) {
        if (check == null) {
            check = car.getPrice();
        } else {
            check = check.add(car.getPrice());
        }
    }

    //закрытие кассовой смены, отчет о сумме выручки

    public BigDecimal closeShift() {
        return check;
    }
}
