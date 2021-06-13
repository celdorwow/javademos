package com.designpatterns;

public class PhilipsLamp implements Lamp {
    private enum State { ON, OFF }
    private static final int MAX_LEVEL = 10;
    private static final int MIN_LEVEL = 0;
    private final String name;
    private int brightness;
    private State state;

    private void clip() {
        brightness = Math.min(brightness, PhilipsLamp.MAX_LEVEL);
        brightness = Math.max(brightness, PhilipsLamp.MIN_LEVEL);
    }

    public PhilipsLamp(int entryLevel) {
        name = "Philips";
        brightness = entryLevel;
        state = entryLevel > 0 ? State.ON : State.OFF;
    }
    public PhilipsLamp() {
        this(5);
    }

    @Override
    public void on() {
        state = State.ON;
    }

    @Override
    public void off() {
        state = State.OFF;
    }

    @Override
    public void toggle() {
        state = state == State.ON ? State.OFF : State.ON;
    }

    @Override
    public void brightUp() {
        brightness++;
        clip();
    }

    @Override
    public void dimDown() {
        brightness--;
        clip();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%s is %s.", name, state));
        if (state == State.ON) {
            s.append(String.format(" Brightness is set to %d.", brightness));
        }
        return s.toString();
    }
}
