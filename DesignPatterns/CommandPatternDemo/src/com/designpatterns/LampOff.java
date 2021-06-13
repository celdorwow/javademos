package com.designpatterns;

public class LampOff implements Command {
    private final Lamp lamp;

    public LampOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.off();
    }
}
