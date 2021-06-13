package com.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final String name;
    private final List<Component> children;

    public Composite(List<Component> components, String name) {
        this.name = name;
        this.children = components;
    }
    public Composite(String name) {
        this(new ArrayList<>(), name);
    }

    @Override
    public void operation() {
        System.out.println(name);
        for(Component c: children) {
            c.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
