package com.designpatterns;

import java.util.List;

public abstract class Appendix {
    protected DocFont font;
    protected List<List<String>> sections;

    Appendix(DocFont f, List<List<String>> ss) {
        font = f;
        sections = ss;
    }

    public String render() {
        return StringRenders.RenderSections(sections);
    }
}
