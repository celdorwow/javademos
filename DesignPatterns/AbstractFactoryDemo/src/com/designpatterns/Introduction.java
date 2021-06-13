package com.designpatterns;

import java.util.List;

public abstract class Introduction {
    protected DocFont font;
    protected List<String> paragraphs;

    Introduction(DocFont f, List<String> ps) {
        font = f;
        paragraphs = ps;
    }

    public String render() {
        return StringRenders.RenderParagraphs(paragraphs);
    }
}
