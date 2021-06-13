package com.designpatterns;

import java.util.List;

public class NullLeaf implements Component {
    private final String name;

    public NullLeaf() {
        this.name = "NullLeaf";
    }

    @Override
    public void operation() {
        System.out.println(name);
    }

    @Override
    public void add(Component component) {}

    @Override
    public void remove(Component component) {}

    @Override
    public List<Component> getChildren() {
        return null;
    }
}
