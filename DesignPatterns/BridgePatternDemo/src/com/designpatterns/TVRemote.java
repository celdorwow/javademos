package com.designpatterns;

public class TVRemote extends Remote {
    public TVRemote(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    @Override
    public void pressChapterUp() {
        // Do nothing
    }

    @Override
    public void pressChapterDown() {
        // Do nothing
    }

    @Override
    public void pressChannelUp() {
        device.numberUp();
    }

    @Override
    public void pressChannelDown() {
        device.numberDown();
    }
}
