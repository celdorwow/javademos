package com.designpatterns;

public class TraditionalTitle extends Title {
    public TraditionalTitle(String content) {
        super(DocFont.LARGE, content, Style.TRADITIONAL);
    }

    @Override
    public String getTitle() {
        return font + ":" + style + ":" + line;
    }
}
