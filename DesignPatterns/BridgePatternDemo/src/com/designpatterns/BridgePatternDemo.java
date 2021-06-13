package com.designpatterns;

public class BridgePatternDemo {
    public static void newline() {
        System.out.println();
    }

    public static void main(String[] args) {
        EntertainmentDevice tv = new TVDevice(2, 100, 5, 10);
        EntertainmentDevice dvd = new DVDDevice(9, 1000, 2, 10);
	    Remote tvRemote = new TVRemote(tv);
	    Remote dvdRemote = new DVDRemote(dvd);

        System.out.println(tv);
        newline();

        System.out.println(dvd);
        newline();

        tvRemote.pressPower();
        System.out.println(tv);
        tvRemote.pressPower();
        newline();

        dvdRemote.pressPower();
        System.out.println(dvd);
        dvdRemote.pressPower();
        newline();

        dvdRemote.pressChapterUp();
        dvdRemote.pressChapterUp();
        dvdRemote.pressChapterUp();
        System.out.println(dvd);
        newline();

        tvRemote.pressChannelDown();
        tvRemote.pressChannelDown();
        tvRemote.pressChannelDown();
        tvRemote.pressChannelDown();
        tvRemote.pressChannelDown();
        System.out.println(tv);
    }
}
