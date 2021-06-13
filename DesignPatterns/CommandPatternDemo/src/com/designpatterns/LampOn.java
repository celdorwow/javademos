package com.designpatterns;

public class LampOn implements Command {
    private final Lamp lamp;

    public LampOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.on();
    }
}
