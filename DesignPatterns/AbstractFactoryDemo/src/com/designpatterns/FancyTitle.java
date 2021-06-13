package com.designpatterns;

public class FancyTitle extends Title {
    public FancyTitle(DocFont f, String content, Style s) {
        super(DocFont.REGULAR, content, Style.FANCY);
    }

    @Override
    public String getTitle() {
        return font + ":" + style + ":" + "~~~ " + line + " ~~~";
    }
}
