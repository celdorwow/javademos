package com.designpatterns;

public abstract class EntertainmentDevice {
    protected final int maxVolume;
    protected int volume;
    protected boolean state;
    protected MinMaxChecker<Integer> mmChecker;

    public EntertainmentDevice(
            int newVolume,
            int newMaxVolume) {
        volume = newVolume;
        maxVolume = newMaxVolume;
        mmChecker = new MinMaxChecker<>(() -> 0);
        state = true;
    }

    public void volumeUp() {
        volume = mmChecker.check(++volume, maxVolume);
    }

    public void volumeDown() {
        volume = mmChecker.check(--volume, maxVolume);
    }

    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public void toggle() {
        state = !state;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String state = this.state ? "ON" : "OFF";
        s.append("Device is ").append(state).append(".");
        s.append(" Volume is set to ").append(volume).append(".");
        return s.toString();
    }

    public abstract void numberUp();     // This may represent something
    public abstract void numberDown();   // different per device
}
