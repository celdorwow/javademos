package com.designpatterns;

public class Editor {
    private String content;
    private final State state;

    public Editor(State state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String val) {
        content = val;
    }

    public void restore() {
        var c = state.pop();
        if (c == null) {
            return;
        }
        content = c;
    }

    public void save() {
        state.push(content);
    }
}
