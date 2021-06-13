package com.designpatterns;

public class LevelDown implements Command {
    private final Lamp lamp;

    public LevelDown(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.dimDown();
    }
}
