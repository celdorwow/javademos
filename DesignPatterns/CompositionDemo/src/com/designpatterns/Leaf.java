package com.designpatterns;

import java.util.List;

public class Leaf implements Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println(name);
    }

    @Override
    public void add(Component component) {
        // Do nothing
    }

    @Override
    public void remove(Component component) {
        // Do nothing
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
