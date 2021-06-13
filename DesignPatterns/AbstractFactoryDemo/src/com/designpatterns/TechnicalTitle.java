package com.designpatterns;

public class TechnicalTitle extends Title {
    public TechnicalTitle(String content) {
        super(DocFont.HUGE, content, Style.TECHNICAL);
    }

    @Override
    public String getTitle() {
        return font + ":" + style + ":" + line;
    }
}
