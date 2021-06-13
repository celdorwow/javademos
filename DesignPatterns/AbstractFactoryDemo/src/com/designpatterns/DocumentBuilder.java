package com.designpatterns;

import java.util.List;

public abstract class DocumentBuilder {
    protected Title title;
    protected Abstract docAbstract;
    protected Introduction introduction;
    protected Body body;
    protected Conclusion conclusion;
    protected Appendix appendix;

    public abstract void makeTitle(String line);
    public abstract void makeAbstract(String content);
    public abstract void makeIntroduction(List<String> paragraphs);
    public abstract void makeBody(List<List<String>> sections);
    public abstract void makeConclusion(List<String> paragraphs);
    public abstract void makeAppendix(List<List<String>> sections);

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%s%n%n", title.getTitle()));
        s.append(String.format("%s%n%n", docAbstract.getContent()));
        s.append(String.format("%s%n%n", introduction.render()));
        s.append(String.format("%s%n%n", body.render()));
        s.append(String.format("%s%n%n", conclusion.render()));
        s.append(String.format("%s%n%n", appendix.render()));
        return s.toString();
    }

    public String render() {
        return toString();
    }
}

