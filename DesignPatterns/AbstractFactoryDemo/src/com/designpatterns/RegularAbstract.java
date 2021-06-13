package com.designpatterns;

public class RegularAbstract extends Abstract {
    public RegularAbstract(String c) {
        super(c, 1.0f);
    }

    @Override
    public String getContent() {
        return font + ":" + content;
    }
}
