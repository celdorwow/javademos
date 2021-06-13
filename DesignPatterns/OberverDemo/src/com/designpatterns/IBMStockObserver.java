package com.designpatterns;

import java.util.Map;

public class IBMStockObserver implements Observer {
    private double ibmPrice;

    public IBMStockObserver() {
        ibmPrice = 0.0;
    }

    @Override
    public void update(Map<String, Double> map) {
        double newPrice = map.get("ibm");
        boolean update = ibmPrice != newPrice;
        ibmPrice = newPrice;
        printUpdate(update);
    }

    public void printUpdate(boolean update) {
        System.out.println((update ? "Update" : "Still")
            + " : IBM price is " + ibmPrice);
    }
}
