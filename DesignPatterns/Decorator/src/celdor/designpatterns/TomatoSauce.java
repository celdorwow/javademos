package celdor.designpatterns;

public class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", TomatoSauce";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 0.30;
    }
}
