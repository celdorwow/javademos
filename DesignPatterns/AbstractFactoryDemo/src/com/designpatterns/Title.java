package com.designpatterns;

public abstract class Title {
    protected DocFont font;
    protected Style style;
    protected String line;

    public Title(DocFont f, String content, Style s) {
        font = f;
        line = content;
        style = s;
    }

    public abstract String getTitle();
}
