package com.designpatterns;

public class DVDDevice extends EntertainmentDevice {
    private int chapter;
    private final int maxChapter;
    private final int minChapter;

    public DVDDevice(
            int newChapter,
            int newMaxChapter,
            int newVolume,
            int newMaxVolume) {
        super(newVolume, newMaxVolume);
        chapter = newChapter;
        maxChapter = newMaxChapter;
        minChapter = 1;
        chapter = mmChecker.check(chapter, minChapter, maxChapter);
    }

    @Override
    public void numberUp() {
        chapter = mmChecker.check(++chapter, minChapter, maxChapter);
    }

    @Override
    public void numberDown() {
        chapter = mmChecker.check(--chapter, minChapter, maxChapter);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append(" Chapter is set on ").append(chapter).append(".");
        return s.toString();
    }
}

