package celdor.designpatterns;

public class DecoratorDemo {
    public static void main(String[] args) {
        Pizza basicPizza = new PlainPizza();
        Pizza tomatoPizza = new TomatoSauce(new PlainPizza());
        Pizza mozPizza = new Mozzarella(new PlainPizza());
        Pizza customPizza = new Mozzarella(new TomatoSauce(new PlainPizza()));

        System.out.println(basicPizza.getDescription() + " for " + basicPizza.getCost());
        System.out.println(tomatoPizza.getDescription() + " for " + tomatoPizza.getCost());
        System.out.println(mozPizza.getDescription() + " for " + mozPizza.getCost());
        System.out.println(customPizza.getDescription() + " for " + customPizza.getCost());
    }
}

