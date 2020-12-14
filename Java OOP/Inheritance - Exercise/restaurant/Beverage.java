package restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliters) {
        super(name, price);
        this.milliliters = milliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
