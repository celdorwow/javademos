package com.designpatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock implements Subject {
    private final List<Observer> observers;
    private double ibmPrice;
    private double applePrice;
    private double amstradPrice;

    public Stock(double imb, double apple, double amstrad) {
        ibmPrice = imb;
        applePrice = apple;
        amstradPrice = amstrad;
        observers = new ArrayList<>();
    }
    public Stock() {
        this(0.0, 0.0, 0.0);
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    @Override
    public void sendUpdate() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("apple", applePrice);
        prices.put("ibm", ibmPrice);
        prices.put("amstrad", amstradPrice);
        for (Observer o: observers) {
            o.update(prices);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        sendUpdate();
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        sendUpdate();
    }

    public void setAmstradPrice(double amstradPrice) {
        this.amstradPrice = amstradPrice;
        sendUpdate();
    }
}
