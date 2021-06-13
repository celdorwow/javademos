package com.designpatterns;

public class LevelUp implements Command {
    private final Lamp lamp;

    public LevelUp(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.brightUp();
    }
}
