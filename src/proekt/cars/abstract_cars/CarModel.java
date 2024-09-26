package proekt.cars.abstract_cars;

import proekt.cars.car_components.WheelDiskEnum;

import java.math.BigDecimal;

public enum CarModel {
    CAMRY(BigDecimal.valueOf(10000), WheelDiskEnum.R17, BigDecimal.valueOf(5000)),
    SOLARA(BigDecimal.valueOf(12000), WheelDiskEnum.R16, BigDecimal.valueOf(8000)),
    HIANCE(BigDecimal.valueOf(15000), WheelDiskEnum.R20, BigDecimal.valueOf(10000)),
    DYNA(BigDecimal.valueOf(22000), WheelDiskEnum.R20, BigDecimal.valueOf(12000));

    private BigDecimal price;
    private WheelDiskEnum wheelDiskEnum;
    private BigDecimal costprice;

    CarModel(BigDecimal price, WheelDiskEnum wheelDiskEnum, BigDecimal costprice) {
        this.price = price;
        this.wheelDiskEnum = wheelDiskEnum;
        this.costprice = costprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public WheelDiskEnum getWheelDiskEnum() {
        return wheelDiskEnum;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }
}

