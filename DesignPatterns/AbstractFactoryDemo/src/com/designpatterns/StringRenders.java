package com.designpatterns;

import java.util.List;

public class StringRenders {
    private static String nl = String.format("%n");

    public static String RenderSections(List<List<String>> sections) {
        StringBuilder s = new StringBuilder();
        for (List<String> sec: sections) {
            s.append(RenderParagraphs(sec));
            s.append(nl);
        }
        return s.toString();
    }

    public static String RenderParagraphs(List<String> paragraphs) {
        StringBuilder s = new StringBuilder();
        for (String par: paragraphs) {
            s.append(par);
            s.append(nl);
        }
        return s.toString();
    }

}
