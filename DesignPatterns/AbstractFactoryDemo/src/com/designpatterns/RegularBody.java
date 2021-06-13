package com.designpatterns;

import java.util.List;

public class RegularBody extends Body {
    RegularBody(List<List<String>> ss) {
        super(DocFont.REGULAR, ss);
    }
}
