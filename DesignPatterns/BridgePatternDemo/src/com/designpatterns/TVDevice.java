package com.designpatterns;

public class TVDevice extends EntertainmentDevice {
    private int channel;
    private final int maxChannel;
    private final int minChannel;

    public TVDevice(
            int newChannel,
            int newMaxChannel,
            int newVolume,
            int newMaxVolume) {
        super(newVolume, newMaxVolume);
        channel = newChannel;
        maxChannel = newMaxChannel;
        minChannel = 1;
        channel = mmChecker.check(channel, minChannel, maxChannel);
    }

    @Override
    public void numberUp() {
        channel = mmChecker.check(++channel, minChannel, maxChannel);
    }

    @Override
    public void numberDown() {
        channel = mmChecker.check(--channel, minChannel, maxChannel);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append(" Channel is set on ").append(channel).append(".");
        return s.toString();
    }
}
