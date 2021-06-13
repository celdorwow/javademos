package com.designpatterns;

import java.util.List;

public class RegularAppendix extends Appendix {
    RegularAppendix(List<List<String>> ss) {
        super(DocFont.REGULAR, ss);
    }
}
