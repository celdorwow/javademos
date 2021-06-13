package com.designpatterns;

public class TechnicalAbstract extends Abstract {
    public TechnicalAbstract(String c) {
        super(c, 2.0f);
    }

    @Override
    public String getContent() {
        return content;
    }
}
