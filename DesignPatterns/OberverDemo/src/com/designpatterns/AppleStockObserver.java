package com.designpatterns;

import java.util.Map;

public class AppleStockObserver implements Observer {
    private double applePrice;

    public AppleStockObserver() {
        applePrice = 0.0;
    }

    @Override
    public void update(Map<String, Double> map) {
        double newPrice = map.get("apple");
        boolean update = applePrice != newPrice;
        applePrice = newPrice;
        printUpdate(update);
    }

    public void printUpdate(boolean update) {
        System.out.println((update ? "Update" : "Still")
            + " : Apple price is " + applePrice);
    }
}
