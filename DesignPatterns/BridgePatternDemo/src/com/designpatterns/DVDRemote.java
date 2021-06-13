package com.designpatterns;

public class DVDRemote extends Remote {
    public DVDRemote(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    @Override
    public void pressChapterUp() {
        device.numberUp();
    }

    @Override
    public void pressChapterDown() {
        device.numberDown();
    }

    @Override
    public void pressChannelUp() {
        // Do nothing
    }

    @Override
    public void pressChannelDown() {
        // Do nothing
    }
}
