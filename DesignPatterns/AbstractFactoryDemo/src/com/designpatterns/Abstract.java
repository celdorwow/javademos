package com.designpatterns;

public abstract class Abstract {
    protected float margin;
    protected DocFont font;
    protected String content;

    Abstract(DocFont f, String c, float m) {
        font = f;
        margin = m;
        content = c;
    }
    Abstract(String c, float m) {
        this(DocFont.REGULAR, c, m);
    }

    public abstract String getContent();
}
