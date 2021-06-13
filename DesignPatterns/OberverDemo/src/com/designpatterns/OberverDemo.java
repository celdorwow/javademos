package com.designpatterns;

public class OberverDemo {
    public static void main(String[] args) {
        // Stock is a Subject type, which notifies observers
        Stock stock = new Stock(199.0, 344.99, 49.34);

        // Create and register observers
        // It needs variable in order to unregister a particular observer
        var amstradObserver = new AmstradStockObserver();
        var appleObserver = new AppleStockObserver();
        var ibmObserver = new IBMStockObserver();
        stock.register(amstradObserver);
        stock.register(appleObserver);
        stock.register(ibmObserver);

        // Notify observers
        notifies(stock);
        System.out.println();

        // Notify observers about current prices
        stock.setAmstradPrice(11.0);
        notifies(stock);
        System.out.println();
        // Notify observer about changes
        stock.setApplePrice(299.49);
        notifies(stock);
        System.out.println();
        //
        stock.unregister(amstradObserver);
        stock.unregister(appleObserver);
        // Unregistered observers are no longer updated
        stock.setIbmPrice(139.00);
        notifies(stock);
        System.out.println();
    }

    public static void notifies(Subject s) {
        s.sendUpdate();
    }
}
