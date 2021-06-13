package com.designpatterns;

import java.util.List;

public interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    List<Component> getChildren();
}
