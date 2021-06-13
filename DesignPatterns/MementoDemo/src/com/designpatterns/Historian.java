package com.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Historian implements State {
    private final List<String> states;

    public Historian() {
        states = new ArrayList<>();
    }

    public void push(String state) {
        states.add(state);
    }

    public String pop() {
        if (states.size() == 0) {
            return null;
        }
        String lastItem = states.get(states.size()-1);
        states.remove(lastItem);
        return lastItem;
    }
}
