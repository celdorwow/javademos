package com.designpatterns;

import java.util.List;

public class JournalPaperBuilder extends DocumentBuilder {
    public JournalPaperBuilder(
                String docTitle,
                String docAbstr,
                List<String> docIntro,
                List<List<String>> docBody,
                List<String> concl,
                List<List<String>> appen) {
        makeTitle(docTitle);
        makeAbstract(docAbstr);
        makeIntroduction(docIntro);
        makeBody(docBody);
        makeConclusion(concl);
        makeAppendix(appen);
    }

    @Override
    public void makeTitle(String line) {
        title = new TechnicalTitle(line);
    }

    @Override
    public void makeAbstract(String content) {
        docAbstract = new TechnicalAbstract(content);
    }

    @Override
    public void makeIntroduction(List<String> paragraphs) {
        introduction = new RegularIntroduction(paragraphs);
    }

    @Override
    public void makeBody(List<List<String>> sections) {
        body = new RegularBody(sections);
    }

    @Override
    public void makeConclusion(List<String> paragraphs) {
        conclusion = new RegularConclusion(paragraphs);
    }

    @Override
    public void makeAppendix(List<List<String>> sections) {
        appendix = new RegularAppendix(sections);
    }
}
