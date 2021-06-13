package com.designpatterns;

import java.util.List;

public class RegularConclusion extends Conclusion {
    RegularConclusion(List<String> ps) {
        super(DocFont.REGULAR, ps, 1.0f);
    }
}
