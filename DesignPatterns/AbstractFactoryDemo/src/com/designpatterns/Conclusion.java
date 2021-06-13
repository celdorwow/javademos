package com.designpatterns;

import java.util.List;

public abstract class Conclusion {
    protected float margin;
    protected DocFont font;
    protected List<String> paragraphs;

    Conclusion(DocFont f, List<String> ps, float m) {
        font = f;
        margin = m;
        paragraphs = ps;
    }

    public String render() {
        return StringRenders.RenderParagraphs(paragraphs);
    }
}
