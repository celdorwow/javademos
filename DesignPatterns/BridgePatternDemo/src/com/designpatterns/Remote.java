package com.designpatterns;

public abstract class Remote {
    protected final EntertainmentDevice device;

    public Remote(EntertainmentDevice newDevice) {
        device = newDevice;
    }

    public void pressVolumeUp() {
        device.volumeUp();
    }

    public void pressVolumeDown() {
        device.volumeDown();
    }

    public void pressPower() {
        device.toggle();
    }

    public abstract void pressChapterUp();
    public abstract void pressChapterDown();
    public abstract void pressChannelUp();
    public abstract void pressChannelDown();
}
