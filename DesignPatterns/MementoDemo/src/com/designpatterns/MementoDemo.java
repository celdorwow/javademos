package com.designpatterns;

public class MementoDemo {
    public static void main(String[] args) {
        State state = new Historian();
        var editor = new Editor(state);

        editor.setContent("Line 1");
        editor.save();
        editor.setContent("Line 2");
        editor.save();
        editor.setContent("Line 3");
        editor.save();
        editor.setContent("Line 4");
        editor.save();
        editor.setContent("Line 5");

        System.out.println(editor.getContent());
        editor.restore();
        System.out.println(editor.getContent());
        editor.restore();
        System.out.println(editor.getContent());
        editor.restore();
        System.out.println(editor.getContent());
        editor.restore();
        System.out.println(editor.getContent());
    }
}
