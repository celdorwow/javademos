package com.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        DocumentBuilder journal = new JournalPaperBuilder(
            "Title of the journal",
            "This is a demo of a document. This is the first object",
            new ArrayList<>(Arrays.asList(
                "Paragraph on introduction 1",
                "Paragraph on introduction 2",
                "Paragraph on introduction 3",
                "Paragraph on introduction 4",
                "End of introduction")
            ),
            new ArrayList<>(Arrays.asList(
                Arrays.asList(
                    "Section 1",
                    "Paragraph 1 of section 1 of body",
                    "Paragraph 2 of section 1 of body",
                    "Paragraph 3 of section 1 of body",
                    "End of section 1"),
                Arrays.asList(
                    "Section 2",
                    "Paragraph 1 of section 2 of body",
                    "Paragraph 2 of section 2 of body",
                    "Paragraph 3 of section 2 of body",
                    "End of section 2"),
                Arrays.asList(
                    "Section 3",
                    "Paragraph 1 of section 2 of body",
                    "End of section 3")
            )),
            new ArrayList<>(Arrays.asList(
                "Paragraph of conclusion 1",
                "Paragraph of conclusion 2",
                "Paragraph of conclusion 3"
            )),
            new ArrayList<>(Arrays.asList(
                Arrays.asList(
                    "Section 1",
                    "Paragraph 1 of section 1 of appendix",
                    "Paragraph 2 of section 1 of appendix",
                    "Paragraph 3 of section 1 of appendix",
                    "End of section 1"),
                Arrays.asList(
                    "Section 2",
                    "Paragraph 1 of section 2 of appendix",
                    "Paragraph 2 of section 2 of appendix",
                    "Paragraph 3 of section 2 of appendix",
                    "End of section 2"),
                Arrays.asList(
                    "Section 3",
                    "Paragraph 1 of section 2 of appendix",
                    "End of section 3")
            ))
        );

        System.out.println(journal);
    }
}
