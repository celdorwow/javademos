package com.designpatterns;

import java.util.Map;

public class AmstradStockObserver implements Observer {
    private double amstradPrice;

    public AmstradStockObserver() {
        amstradPrice = 0.0;
    }

    @Override
    public void update(Map<String, Double> map) {
        double newPrice = map.get("amstrad");
        boolean update = amstradPrice != newPrice;
        amstradPrice = newPrice;
        printUpdate(update);
    }

    public void printUpdate(boolean update) {
        System.out.println((update ? "Update" : "Still")
            + " : Amstrad price is " + amstradPrice);
    }
}
