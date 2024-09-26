package proekt;

import java.math.BigDecimal;
/*
Покупатель
 */

public class Bayer {
    private String name;
    private BigDecimal money;

    public Bayer(String name, BigDecimal money) {
        this.name = name;
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
