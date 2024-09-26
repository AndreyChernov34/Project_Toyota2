package proekt;

import proekt.cars.Dyna;
import proekt.cars.Hiance;
import proekt.cars.Solara;
import proekt.cars.abstract_cars.Car;
import proekt.cars.abstract_cars.CarModel;
import proekt.cars.car_components.StartCarException;
import proekt.cars.Camry;
import proekt.cars.car_components.Wheel;
import proekt.cars.car_components.WheelDiskEnum;
import proekt.factory.*;

import java.math.BigDecimal;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        Factory factoryJapan = new Factory(Country.JAPAN);

        // проверка неправильного назначения фабрики к конвейеру
        AssemblyLine assemblyLineRussia = new AssemblyLine(Country.RUSSIA);
        try {
            assemblyLineRussia.setFactory(factoryJapan);

        } catch (CountryFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }

        // Создаем конвейер из страны JAPAN и задаем ему фабрику компонентов из JAPAN
        AssemblyLine assemblyLineJapan = new AssemblyLine(Country.JAPAN);
        try {
            assemblyLineJapan.setFactory(factoryJapan);
        } catch (CountryFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }

        // создаем 4 разные авто и тестируем их свойства
        Camry camry = assemblyLineJapan.createCamry("black", CarModel.CAMRY.getPrice());
        testCar(camry);
        camry.cruizeChange();
        camry.cruizeChange();
        camry.usb();

        Dyna dyna = assemblyLineJapan.createDyna("black", CarModel.DYNA.getPrice());
        testCar(dyna);
        dyna.chargePhone();
        dyna.chargePhone();
        System.out.println("грузоподьемность: " + dyna.getLiftingCapacity());

        Hiance hiance = assemblyLineJapan.createHiance("black", CarModel.HIANCE.getPrice());
        testCar(hiance);
        System.out.println("грузоподьемность: " + hiance.getLiftingCapacity());
        System.out.println("запасное колесо размером " + hiance.getSpareWheel().getWheelDisk().name());
        hiance.setSpareWheel(new Wheel(WheelDiskEnum.R17));

        Solara solara = assemblyLineJapan.createSolara("white", CarModel.SOLARA.getPrice());
        testCar(solara);
        solara.roofChange();
        solara.roofChange();
        solara.freeze();

        //создаем склад и помещаем туда созданные авто
        Warehouse warehouse = new Warehouse();
        warehouse.addCar(camry);
        warehouse.addCar(dyna);
        warehouse.addCar(solara);
        warehouse.addCar(hiance);

        System.out.println(String.format("на складе сейчас %sшт Camry\n", warehouse.getCountModelCars(CarModel.CAMRY)));
        System.out.println(String.format("Всего на складе %s автомобиля.\n", warehouse.getCountAllCars()));

        //Менеджер №1
        Manager manager1 = new Manager("Михаил");

        //Кассир №1
        Cashier cashier1 = new Cashier();

        //Покупатель №1
        Bayer bayer1 = new Bayer("Андрей", BigDecimal.valueOf(10000));
        saleCar(manager1, bayer1, cashier1, warehouse, assemblyLineJapan);

        //Покупатель №2
        Bayer bayer2 = new Bayer("Сергей", BigDecimal.valueOf(12000));
        saleCar(manager1, bayer2, cashier1, warehouse, assemblyLineJapan);

        //Покупатель №3
        Bayer bayer3 = new Bayer("Елена", BigDecimal.valueOf(15000));
        saleCar(manager1, bayer3, cashier1, warehouse, assemblyLineJapan);

        //Покупатель №4
        Bayer bayer4 = new Bayer("Гога", BigDecimal.valueOf(22000));
        saleCar(manager1, bayer4, cashier1, warehouse, assemblyLineJapan);

        //кассир №2
        Cashier cashier2 = new Cashier();
        //Покупатель №5
        Bayer bayer5 = new Bayer("Василий", BigDecimal.valueOf(11000));
        saleCar(manager1, bayer5, cashier2, warehouse, assemblyLineJapan);

        Bayer bayer6 = new Bayer("Анна", BigDecimal.valueOf(13200));
        saleCar(manager1, bayer6, cashier2, warehouse, assemblyLineJapan);

        Bayer bayer7 = new Bayer("Ашот", BigDecimal.valueOf(8000));
        saleCar(manager1, bayer7, cashier2, warehouse, assemblyLineJapan);

        Bayer bayer8 = new Bayer("Юрий", BigDecimal.valueOf(30000));
        saleCar(manager1, bayer8, cashier2, warehouse, assemblyLineJapan);

        // Формируем отчет о выручке по всем кассирам, независимо от того кто отчитывается
        System.out.println("Итого выручка " + cashier2.closeShift());

        // записываем в файл отчет менеджера по продажам
        manager1.generateReport();
    }

    //метод проверки стандартных свойств автомобиля
    private static void testCar(Car car) {
        System.out.println("_________________________");
        System.out.println("тестируем " + car.getCarModel().name());

        car.headlightChange();
        car.headlightChange();
        car.fuelTank.getFuel();
        car.fuelTank.setFuel(5);
        car.wheels[0].setPuncture(true);
        car.wheelchange(new Wheel(WheelDiskEnum.R15), 0);
        car.wheelchange(new Wheel(WheelDiskEnum.R16), 0);
        car.wheelchange(new Wheel(WheelDiskEnum.R17), 0);
        car.wheelchange(new Wheel(WheelDiskEnum.R18), 0);
        car.wheelchange(new Wheel(WheelDiskEnum.R19), 0);
        car.wheelchange(new Wheel(WheelDiskEnum.R20), 0);

        if (car.getEngine().isFunctional() == true) {
            System.out.println("двигатель работает");
        }
        try {
            car.start();
        } catch (StartCarException e2) {
            System.out.println(e2.getMessage());
        }
        car.stop();
    }

    //метод продажи автомобиля.
    private static void saleCar(Manager manager, Bayer bayer, Cashier cashier,
                                Warehouse warehouse, AssemblyLine assemblyLine) {
        Optional<Car> salecar = Optional.ofNullable(manager.sale(bayer, warehouse, assemblyLine));
        if (!salecar.isEmpty()) {
            manager.report.addReport(salecar.get());
            cashier.recievePayment(salecar.get());
        } else {
            System.out.format("у покупателя %s недостаточно средств %s \n", bayer.getName(), bayer.getMoney());
        }
    }
}