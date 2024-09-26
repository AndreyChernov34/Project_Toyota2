package proekt;

import proekt.cars.abstract_cars.Car;
import proekt.cars.abstract_cars.CarModel;
import proekt.factory.AssemblyLine;
import proekt.factory.Warehouse;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import static proekt.cars.abstract_cars.CarModel.HIANCE;

/*
Менеджер
 */

public class Manager {
    public String name;
    public Report report = new Report(name);
    public BigDecimal sumSale = BigDecimal.ZERO;
    public BigDecimal sumCost = BigDecimal.ZERO;

    public Manager(String name) {
        this.name = name;
    }

    // продажа авто

    public Car sale(Bayer bayer, Warehouse warehouse, AssemblyLine assemblyLine) {
        //проверяем есть ли на складе и подбираем самую дорогую модель
        if (warehouse.getCountAllCars() > 0) {
            if ((bayer.getMoney().compareTo(CarModel.DYNA.getPrice()) >= 0) &&
                    (warehouse.getCountModelCars(CarModel.DYNA) > 0)) {
                return warehouse.takeCar(CarModel.DYNA);

            } else if ((bayer.getMoney().compareTo(HIANCE.getPrice()) >= 0)
                    && (warehouse.getCountModelCars(HIANCE) > 0)) {
                return warehouse.takeCar(HIANCE);

            } else if ((bayer.getMoney().compareTo(CarModel.SOLARA.getPrice()) >= 0)
                    && (warehouse.getCountModelCars(CarModel.SOLARA) > 0)) {
                return warehouse.takeCar(CarModel.SOLARA);

            } else if ((bayer.getMoney().compareTo(CarModel.CAMRY.getPrice()) >= 0)
                    && (warehouse.getCountModelCars(CarModel.CAMRY) > 0)) {
                return warehouse.takeCar(CarModel.CAMRY);
            }
        }

        //Если нет на складе, то заказываем на конвейере выпуск максимально дорогой модели
        if (bayer.getMoney().compareTo(BigDecimal.valueOf(1.1).multiply(CarModel.DYNA.getPrice())) >= 0) {
            return assemblyLine.createDyna("black", BigDecimal.valueOf(1.1)
                    .multiply(CarModel.DYNA.getPrice()));
        } else if (bayer.getMoney().compareTo(BigDecimal.valueOf(1.1).multiply(HIANCE.getPrice())) >= 0) {
            return assemblyLine.createHiance("black", BigDecimal.valueOf(1.1)
                    .multiply(HIANCE.getPrice()));
        } else if (bayer.getMoney().compareTo(BigDecimal.valueOf(1.1).multiply(CarModel.SOLARA.getPrice())) >= 0) {
            return assemblyLine.createSolara("black", BigDecimal.valueOf(1.1)
                    .multiply(CarModel.SOLARA.getPrice()));
        } else if (bayer.getMoney().compareTo(BigDecimal.valueOf(1.1).multiply(CarModel.CAMRY.getPrice())) >= 0) {
            return assemblyLine.createCamry("black", BigDecimal.valueOf(1.1)
                    .multiply(CarModel.CAMRY.getPrice()));
        }

        //если не хватило денег, то возвращаем null
        return null;

    }

    public void generateReport() {

        try (FileWriter fileWriter = new FileWriter("report.txt", false)) {
            fileWriter.write("Имя менеджера:" + name + "\n");
            fileWriter.write("МОДЕЛЬ:\tЦЕНА ПРОДАЖИ\tСЕБЕСТОИМОСТЬ \n");

            report.cars.forEach(car -> {
                try {
                    String line = car.getCarModel() + "\t\t" + car.getPrice() + "\t\t\t"
                            + car.getCarModel().getCostprice() + "\n";
                    fileWriter.write(line);
                    sumSale = sumSale.add(car.getPrice());
                    sumCost = sumCost.add(car.getCarModel().getCostprice());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            String line = String.format("ИТОГ доходы: %s, расходы: %s, прибыль: %s",
                    sumSale, sumCost, sumSale.subtract(sumCost));
            fileWriter.write(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
